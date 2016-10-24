// COPYRIGHT_BEGIN
// COPYRIGHT_END

// Declare package.
package com.wizzer.mle.parts.props;

// Import Magic Lantern classes.
import com.wizzer.mle.math.MlVector3;
import com.wizzer.mle.parts.IMlePropPart;

/**
 * This interface is used to implement a Translation property.
 */
public interface IMleTranslationProperty extends IMlePropPart
{
    /**
     * Get the property value.
     *
     * @return A <code>MlVector3</code> is returned.
     */
    MlVector3 getProperty();

    /**
     * Set the property value.
     *
     * @param translation This argument should be a <code>MlVector3</code>.
     */
    void setProperty(MlVector3 translation);
}
