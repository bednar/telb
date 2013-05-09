# Tapestry5 Expression Language Binding

## Description

Actually support **only OGNL** expression language.

### Tapestry template

    <t:mypackage.mycomponent myparameter="el:@System@currentTimeMillis()"/>
    
### Tapestry binding prefix

    import org.apache.tapestry5.annotations.Parameter;
    import com.github.bednar.TELBConstants;

    public class MySuperComponent
    {
        @Parameter(defaultPrefix = TELBConstants.EXPRESSION_LANGUAGE_BINDING)
        private Long parameter;
    }
    
### Dependencies version

 - Tapestry5 - 5.3.7
 - OGNL - 2.7.3
 - MVEL - **not supported yet**

### Maven dependency

    <dependency>
        <groupId>com.github.bednar</groupId>
        <artifactId>telb</artifactId>
        <version>1.0.0</version>
    </dependency>

## Links
 - [Tapestry5](http://tapestry.apache.org/), [Bindings](http://tapestry.apache.org/component-parameters.html#ComponentParameters-BindingExpressions)
 - [OGNL](http://commons.apache.org/proper/commons-ognl/)
 - [MVEL](http://mvel.codehaus.org)

## License

[New BSD License](http://en.wikipedia.org/wiki/BSD_licenses#3-clause_license_.28.22Revised_BSD_License.22.2C_.22New_BSD_License.22.2C_or_.22Modified_BSD_License.22.29)
