package ma.glasnost.orika.impl.generator.specification;

import static ma.glasnost.orika.impl.generator.SourceCodeContext.statement;
import ma.glasnost.orika.impl.generator.SourceCodeContext;
import ma.glasnost.orika.impl.generator.VariableRef;
import ma.glasnost.orika.metadata.FieldMap;
import ma.glasnost.orika.metadata.Property;

public class PrimitiveToWrapper extends AbstractSpecification {

    public boolean appliesTo(FieldMap fieldMap) {
        return fieldMap.getDestination().getType().isPrimitiveWrapper() && fieldMap.getSource().isPrimitive();
    }

    public String generateEqualityTestCode(VariableRef source, VariableRef destination, Property inverseProperty, SourceCodeContext code) {
        return source + " == " + destination;
    }

    public String generateMappingCode(VariableRef source, VariableRef destination, Property inverseProperty, SourceCodeContext code) {
        return statement(destination.assign("%s.valueOf(%s)", destination.typeName(), source));
    }
}
