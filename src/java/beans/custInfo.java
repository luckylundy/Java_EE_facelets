package beans;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class custInfo {
    
    // ****** フィールド ******
    
    // ******お客様情報 ******
    private String name;                        // 名前
    private int ads1;                           // 住所１
    private String ads2;                        // 住所２
    private String gender;                      // 性別
    private String b_type;                      // 血液型
    private String phone;                       // 電話番号
    private Date b_date;                        // 生年月日
    
    // ****** ご注文情報 ******
    @ItemCodeConstraint(prefix="MSR", fixed_st=1234, fixed_ed=1234)
    private String item_cd;                     // 商品コード
    @Size(min=2, max=30)
    private String item_nm;                     // 商品名
    @Min(100) @Max(1000000)
    private Integer price;                      // 商品単価
    @Min(1) @Max(100)
    private Integer quantity;                   // 数量
    
    // ****** お客様アンケート ******
    private int[] hobby;                        // 趣味
    private List<String> sports;                // スポーツ
    private int[] domestic;                     // 旅行先（国内）
    private List<String> abroad;                // 旅行先（海外）
    private List<String> music;                 // 音楽
    private List<String> game;                  // ゲーム
    private List<String> shopping;              // ショッピング
    

    
    // *********************** UIコンポーネント・リストデータ初期化処理 ***************************
    
    // ***** 住所１ *****
    static final Map<String, Integer> adsList;
    static{
        adsList = new LinkedHashMap();
        adsList.put("東京都", 10);
        adsList.put("神奈川県", 11);
        adsList.put("千葉県", 12);
        adsList.put("埼玉県", 13);
    }
    
    // ***** 趣味 *****
    static final Map<String, Integer> hobbyList;
    static{
        hobbyList = new LinkedHashMap();
        hobbyList.put("スポーツ", 1);
        hobbyList.put("ショッピング", 2);
        hobbyList.put("旅行", 3);
        hobbyList.put("映画鑑賞", 4);
        hobbyList.put("音楽鑑賞", 5);
        hobbyList.put("ゲーム", 6);
        hobbyList.put("その他", 7);
    }
    
    // ***** 旅行先（海外） *****
    static final Map<String, String> abroadList;
    static{
        abroadList = new LinkedHashMap();
        abroadList.put("アメリカ・カナダ", "アメリカ");
        abroadList.put("南米諸国", "南米");
        abroadList.put("中国", "中国");
        abroadList.put("韓国", "韓国");
        abroadList.put("東南アジア諸国", "アジア");
        abroadList.put("中東諸国", "中東");
        abroadList.put("ヨーロッパ諸国", "ヨーロッパ");
        abroadList.put("アフリカ大陸諸国", "アフリカ");
        abroadList.put("南極大陸", "南極");
    }
    
    // ***** ゲーム *****
    static final Map<String, String> gameList;
    static{
        gameList = new LinkedHashMap();
        gameList.put("シューティング", "STG");
        gameList.put("アクション", "ATC");
        gameList.put("アドベンチャー", "ADV");
        gameList.put("ロールプレイング", "RPG");
        gameList.put("格闘", "BTL");
        gameList.put("パズル", "PZL");
        gameList.put("レース", "RCG");
        gameList.put("シミュレーション", "SLG");
        gameList.put("音楽", "RTG");
        gameList.put("その他", "other");
    }
    
    // ***** ショッピング *****
    static final Map<String, String> shoppingList;
    static{
        shoppingList = new LinkedHashMap();
        shoppingList.put("ファッション", "fashion");
        shoppingList.put("ビューティー", "beauty");
        shoppingList.put("ホーム・キッチン", "home");
        shoppingList.put("スポーツ・アウトドア", "sports");
        shoppingList.put("本・コミック・雑誌", "books");
        shoppingList.put("ミュージック", "music");
        shoppingList.put("DVD・ブルーレイ", "dvd");
        shoppingList.put("家電・カメラ・AV機器", "electric");
        shoppingList.put("パソコン・周辺装置", "pc");
        shoppingList.put("テレビゲーム", "game");
        shoppingList.put("おもちゃ", "toys");
        shoppingList.put("ドラッグストア", "drug");
        shoppingList.put("車・バイク", "auto");
        shoppingList.put("食品・飲料・お酒", "foods");
    }
    
    // ***** 旅行先（国内） *****（表示データ変換用Mapオブジェクト）
    static final Map<String, Integer> domesticList;
    static{
        domesticList = new LinkedHashMap();
        domesticList.put("北海道", 10);
        domesticList.put("東北", 20);
        domesticList.put("上越", 30);
        domesticList.put("関東", 40);
        domesticList.put("東海", 50);
        domesticList.put("関西・四国", 60);
        domesticList.put("北陸", 70);
        domesticList.put("中国・四国", 80);
        domesticList.put("九州・沖縄", 90);
    }
    
    // ***** 音楽 *****
    static final Map<String, String> musicList;
    static{
        musicList = new LinkedHashMap();
        musicList.put("ポップス", "POPS");
        musicList.put("J-ポップ", "J-POP");
        musicList.put("K-ポップ", "K-POP");
        musicList.put("ロック", "ROCK");
        musicList.put("ハードロック・ヘビーメタル", "HR/HM");
        musicList.put("ジャズ・フュージョン", "JAZZ");
        musicList.put("RB・レゲエ", "RB");
        musicList.put("歌謡曲・演歌", "SONG");
        musicList.put("クラシック", "CLASSIC");
        musicList.put("その他", "OTHER");
    }
    
    /*
    変換処理
    内部処理値→表示文字列
    ---------------------------------------------------------------------------------------------------------------------------------
    数値 → 文字列（単一選択）           住所1
    文字列 → 文字列（単一選択）         性別
    数値 → 文字列（複数選択）           趣味、旅行先（国内）
    文字列 → 文字列（複数選択）         旅行先（海外）、音楽、ゲーム・ショッピング
    */
    
    // *****************************************************************************************************************************
    // 形式：public StringBuilder convertValueToKey_ItoS(int[] selected, Map<String, Integer> map
    // メソッド名：convertValueToKey_ItoS
    // 引数：int[] selected         UIコンポーネントにて選択されたリストデータ内の内部処理値（数値）
    //       Map<String, Integer>   UIコンポーネントのリストデータを定義しているMapオブジェクト
    // 戻り値：StringBuilder        Mapオブジェクトから取得した表示値（文字列）をカンマ区切りにした文字列
    // -----------------------------------------------------------------------------------------------------------------------------
    // 入力画面の選択系UIコンポーネントにて選択されたデータ（内部処理値）に該当する全ての表示値（表示文字列）を
    // Mapのキーから取得し、カンマ区切りの文字列に編集したものを結果として返す。
    // *****************************************************************************************************************************
    public StringBuilder convertValueToKey_ItoS(int[] selected, Map<String, Integer> map){
    
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < selected.length; i++){       // 選択されたデータ件数分をループ
            for(String key : map.keySet()){             // UIコンポーネント用のオブジェクト（Map）からキー部分を取得
                if(selected[i] == map.get(key)){        // 選択されたデータとMapオブジェクトの値（value）を比較 map.get(key)でmap.valueの値が出る
                    sb.append(key);             
                    if(i != selected.length - 1)        // データの最後でなければカンマを付加する
                        sb.append(",");
                }
            }
        }
        return sb;
}

    // *****************************************************************************************************************************
    // 形式：public StringBuilder convertValueToKey_StoS(List<String> selected, Map<String, String> map
    // メソッド名：convertValueToKey_StoS
    // 引数：List<String> selected         UIコンポーネントにて選択されたリストデータ内の内部処理値（文字列）
    //       Map<String, String>   UIコンポーネントのリストデータを定義しているMapオブジェクト
    // 戻り値：StringBuilder        Mapオブジェクトから取得した表示値（文字列）をカンマ区切りにした文字列
    // -----------------------------------------------------------------------------------------------------------------------------
    // 入力画面の選択系UIコンポーネントにて選択されたデータ（内部処理値）に該当する全ての表示値（表示文字列）を
    // Mapのキーから取得し、カンマ区切りの文字列に編集したものを結果として返す。
    // *****************************************************************************************************************************
    public StringBuilder convertValueToKey_StoS(List<String> selected, Map<String, String> map){
    
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < selected.size(); i++){                // 選択されたデータ件数分をループ
            for(String key : map.keySet()){                      // UIコンポーネント用のオブジェクト（Map）からキー部分を取得
                if(selected.get(i).equals(map.get(key))){        // 選択されたデータとMapオブジェクトの値（value）を比較 map.get(key)でmap.valueの値が出る
                    sb.append(key);             
                    if(i != selected.size() - 1)                 // データの最後でなければカンマを付加する
                        sb.append(",");
                }
            }
        }
        return sb;
}
    
    
    
    
    
    // *****セッター*****
    public void setName(String name) {
        this.name = name;
    }

    public void setAds1(int ads1) {
        this.ads1 = ads1;
    }

    public void setAds2(String ads2) {
        this.ads2 = ads2;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setB_type(String b_type) {
        this.b_type = b_type;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setB_date(Date b_date) {
        this.b_date = b_date;
    }

    public void setItem_cd(String item_cd) {
        this.item_cd = item_cd;
    }

    public void setItem_nm(String item_nm) {
        this.item_nm = item_nm;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setHobby(int[] hobby) {
        this.hobby = hobby;
    }

    public void setSports(List<String> sports) {
        this.sports = sports;
    }

    public void setDomestic(int[] domestic) {
        this.domestic = domestic;
    }

    public void setAbroad(List<String> abroad) {
        this.abroad = abroad;
    }

    public void setMusic(List<String> music) {
        this.music = music;
    }

    public void setGame(List<String> game) {
        this.game = game;
    }

    public void setShopping(List<String> shopping) {
        this.shopping = shopping;
    }
    
    // ***** ゲッター *****
    public String getName() {
        return name;
    }

    public int getAds1() {
        return ads1;
    }

    public String getAds2() {
        return ads2;
    }

    public String getGender() {
        return gender;
    }

    public String getB_type() {
        return b_type;
    }

    public String getPhone() {
        return phone;
    }

    public Date getB_date() {
        return b_date;
    }

    public String getItem_cd() {
        return item_cd;
    }

    public String getItem_nm() {
        return item_nm;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public int[] getHobby() {
        return hobby;
    }

    public List<String> getSports() {
        return sports;
    }

    public int[] getDomestic() {
        return domestic;
    }

    public List<String> getAbroad() {
        return abroad;
    }

    public List<String> getMusic() {
        return music;
    }

    public List<String> getGame() {
        return game;
    }

    public List<String> getShopping() {
        return shopping;
    }

    // ***** UIコンポーネント・リストデータのゲッター *****
    public Map<String, Integer> getAdsList() {
        return adsList;
    }

    public Map<String, Integer> getHobbyList() {
        return hobbyList;
    }

    public Map<String, String> getAbroadList() {
        return abroadList;
    }

    public Map<String, String> getGameList() {
        return gameList;
    }

    public Map<String, String> getShoppingList() {
        return shoppingList;
    }
    
    // ***** 表示用データの取得 *****
    
    // 性別の表示データ取得
    public String getGenderValue(){
        if(gender.equals("男")) return "男性";
        else return "女性";
    }
    
    // 住所1の表示データの取得
    public String getAds1Value(){
        String ret = null;
        for(String key : adsList.keySet()){
            if(getAds1() == adsList.get(key)){
                ret = key;
                break;
            }
        }
        return ret;
    }
    
    // 住所データの編集
    public String getAdsValue(){
        return getAds1Value() + getAds2();
    }
    
    // ご請求金額の表示データ取得
    public int getTotalPriceValue(){
        return (int) (price * quantity * 1.1);
    }
    
    // スポーツの表示データの取得
    public StringBuilder getSportsValue(){
        StringBuilder sb = new StringBuilder();
        for(String data : sports){
            sb.append(data).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1);
    }
    
    // 趣味の表示データの取得
    public StringBuilder getHobbyValue(){
        return convertValueToKey_ItoS(hobby, hobbyList);
    }
    
    // 旅行先（国内）の表示データ取得
    public StringBuilder getDomesticValue(){
        return convertValueToKey_ItoS(domestic, domesticList);
    }
    
    // 旅行先（海外）の表示データ取得
    public StringBuilder getAbroadValue(){
        return convertValueToKey_StoS(abroad, abroadList);
    }
    
    // 音楽の表示データ取得
    public StringBuilder getMusicValue(){
        return convertValueToKey_StoS(music, musicList);
    }
    
    // ゲームの表示データ取得
    public StringBuilder getGameValue(){
        return convertValueToKey_StoS(game, gameList);
    }
    
    // ショッピングの表示データ取得
    public StringBuilder getShoppingValue(){
        return convertValueToKey_StoS(shopping, shoppingList);
    }
    
    
    public String showResult() {
        return "result.xhtml";
    }
    
    

    
}
