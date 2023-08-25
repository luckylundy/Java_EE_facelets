package beans;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
ItemCodeValidator（バリデータクラス）で行う判定処理

商品コードの形式
SSS-9999-9999（Sは文字列、9は数字、ハイフンは区切り文字）
prefix => パラメータ（引数）に指定された値（先頭3文字）
fixed_st => パラメータ（引数）に指定された値（真ん中の数字部の開始値）
fixed_ed => パラメータ（引数）に指定された値（真ん中の数字部の終了値）
*/

public class ItemCodeValidator implements ConstraintValidator<ItemCodeConstraint, String> {
    
    private String prefix;
    private int fixed_st;
    private int fixed_ed;
    
    private final int PARAM_LEN = 13;
    
    @Override
    public void initialize(ItemCodeConstraint element){
        prefix = element.prefix();
        fixed_st = element.fixed_st();
        fixed_ed = element.fixed_ed();
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        
        // 未入力と文字列長のチェック
        if(value == null || value.isEmpty() || value.length() != PARAM_LEN){
            return false;
        }
        // 先頭文字とハイフン部分のチェック
        else if(! value.startsWith(prefix) || 
               ! value.substring(3, 4).equals("-") ||
               ! value.substring(8, 9).equals("-")){
            return false;
        }
        
        try{
            // 固定数字部分と任意数字部分の取得
            int mid_val = Integer.parseInt(value.substring(4, 8));
            int end_val = Integer.parseInt(value.substring(9));
            
            // 固定数字部分の範囲判定チェック
            if(mid_val<fixed_st || mid_val> fixed_ed){
                return false;
            }
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    
    
}
