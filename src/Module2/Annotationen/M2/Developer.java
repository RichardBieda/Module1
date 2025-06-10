package Module2.Annotationen.M2;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Developer {

    String name();
    int year() default 2025;
}
