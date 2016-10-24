// COPYRIGHT_BEGIN
// COPYRIGHT_END

// Declare package.
package com.wizzer.mle.parts.props;

// Import Magic Lantern packages.
import com.wizzer.mle.math.MlVector3;
import com.wizzer.mle.parts.IMlePropPart;

/**
 * This interface is used to implement a Scale property.
 */
public interface IMleNonuniformScaleProperty extends IMlePropPart
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
     * @param scale This argument should be a <code>MlVector3</code>.
     */
    void setProperty(MlVector3 scale);
}
