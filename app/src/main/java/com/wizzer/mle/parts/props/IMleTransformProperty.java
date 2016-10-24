// COPYRIGHT_BEGIN
// COPYRIGHT_END

// Declare package.
package com.wizzer.mle.parts.props;

// Import Magic Lantern classes.
import com.wizzer.mle.math.MlTransform;
import com.wizzer.mle.parts.IMlePropPart;

/**
 * This interface is used to define a Transform property.
 */
public interface IMleTransformProperty extends IMlePropPart
{
    /**
     * Get the property value.
     *
     * @return A <code>MlTransform</code> is returned.
     */
     MlTransform getProperty();

    /**
     * Set the property value.
     *
     * @param transform This argument should be a <code>MlTransform</code>.
     */
    void setProperty(MlTransform transform);
}
