# [![Build Status](https://travis-ci.org/bednar/telb.png?branch=master)](https://travis-ci.org/bednar/telb) Tapestry5 Expression Language Binding

## Description

Support three binding prefix:

1. __el__ - Default Expression Language (OGNL)
2. __ognl__ - Object Graph Navigation Library
3. __mvel__ - MVFLEX Expression Language

### Tapestry template

#### Default

    <t:mypackage.mycomponent1 parameter="el:@System@currentTimeMillis()"/>
    
    <t:mypackage.mycomponent2 parameter="el:currentValue + 1"/>
    
#### OGNL

    <t:mypackage.mycomponent1 parameter="ognl:@System@currentTimeMillis()"/>
    
    <t:mypackage.mycomponent2 parameter="ognl:currentValue + 1"/>
    
#### MVEL

    <t:mypackage.mycomponent1 parameter="mvel:System.currentTimeMillis()"/>
    
    <t:mypackage.mycomponent2 parameter="mvel:currentValue + 1"/>
    
### Tapestry binding prefix

#### Default

    import org.apache.tapestry5.annotations.Parameter;
    import com.github.bednar.TELBConstants;

    public class MySuperComponent
    {
        @Parameter(defaultPrefix = TELBConstants.EXPRESSION_LANGUAGE)
        private Long parameter;
    }
    
#### OGNL

    import org.apache.tapestry5.annotations.Parameter;
    import com.github.bednar.TELBConstants;

    public class MySuperComponent
    {
        @Parameter(defaultPrefix = TELBConstants.OGNL)
        private Long parameter;
    }
    
#### MVEL

    import org.apache.tapestry5.annotations.Parameter;
    import com.github.bednar.TELBConstants;

    public class MySuperComponent
    {
        @Parameter(defaultPrefix = TELBConstants.MVEL)
        private Long parameter;
    }
    
### Overide default expression language

    public void contributeApplicationDefaults(final @Nonnull MappedConfiguration<String, String> configuration)
    {
        configuration.add(TELBConstants.DEFAULT_EL_SYMBOL, TELBConstants.MVEL);
    }

### Dependencies

 - Tapestry5 - 5.3.7
 - OGNL - 2.7.3
 - MVEL - 2.1.4.Final

### Maven

#### Release
Synced to Maven Central Repository.

    <dependency>
        <groupId>com.github.bednar</groupId>
        <artifactId>telb</artifactId>
        <version>1.0.0</version>
    </dependency>
    
#### Snapshot

    <dependency>
        <groupId>com.github.bednar</groupId>
        <artifactId>telb</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
    
    <repositories>
        <repository>
            <id>sonatype-nexus-snapshots</id>
            <name>Sonatype Nexus Snapshots</name>
            <url>https://oss.sonatype.org/content/repositories/snapshots</url>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
    
## Links
 - [Tapestry5](http://tapestry.apache.org/), [Bindings](http://tapestry.apache.org/component-parameters.html#ComponentParameters-BindingExpressions)
 - [OGNL](http://commons.apache.org/proper/commons-ognl/)
 - [MVEL](http://mvel.codehaus.org)

## License

[New BSD License](http://en.wikipedia.org/wiki/BSD_licenses#3-clause_license_.28.22Revised_BSD_License.22.2C_.22New_BSD_License.22.2C_or_.22Modified_BSD_License.22.29)
