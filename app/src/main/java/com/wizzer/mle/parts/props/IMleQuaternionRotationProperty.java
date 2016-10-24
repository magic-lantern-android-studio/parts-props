// COPYRIGHT_BEGIN
// COPYRIGHT_END

// Declare package.
package com.wizzer.mle.parts.props;

// Import Magic Lantern classes.
import com.wizzer.mle.math.MlRotation;
import com.wizzer.mle.parts.IMlePropPart;

/**
 * This interface is used to define a Rotation property.
 */
public interface IMleQuaternionRotationProperty extends IMlePropPart
{
    /**
     * Get the property value.
     *
     * @return A <code>MlRotation</code> is returned.
     */
    MlRotation getProperty();

    /**
     * Set the property value.
     *
     * @param rotation This argument should be a <code>MlRotation</code>.
     */
    void setProperty(MlRotation rotation);
}
