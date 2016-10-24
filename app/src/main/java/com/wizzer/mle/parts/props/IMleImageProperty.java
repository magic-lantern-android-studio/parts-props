// COPYRIGHT_BEGIN
// COPYRIGHT_END

// Declare package.
package com.wizzer.mle.parts.props;

// Import Magic Lantern classes.
import com.wizzer.mle.parts.j2d.props.IImageProperty;
import com.wizzer.mle.runtime.core.MleMediaRef;

/**
 * This interface is used to define an Image Property.
 */
public interface IMleImageProperty extends IImageProperty
{
    /**
     * Get the property value.
     *
     * @return A <code>MleMediaRef</code> is returned.
     */
    MleMediaRef getProperty();

    /**
     * Set the property value.
     *
     * @param reference This argument should be a <code>MleMediaRef</code>.
     */
    void setProperty(MleMediaRef reference);
}
