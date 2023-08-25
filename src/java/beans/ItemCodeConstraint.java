package beans;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ItemCodeValidator.class)
public @interface ItemCodeConstraint {

    String message() default "{beans.ItemCodeConstraint}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    /*
    @ItemCodeConstraintのパラメータの初期化
    */
    String prefix() default "";
    int fixed_st()default 1000;
    int fixed_ed() default 9999;
    
    
}
