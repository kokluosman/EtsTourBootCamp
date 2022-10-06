package com.etstour.hotelbooking.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = FieldMatchValidator.class)
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldMatch {

    //Custom annotation or finding matches between two string fields

    String message() default  "";
    Class<?>[] groups() default  {};
    Class<? extends Payload>[] payload() default {};

    String first();
    String second();

    //make list annotation list to match each one is in.
    @Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List{
        FieldMatch[] value();
    }

}
