package com.wizzer.mle.parts.props;

import com.wizzer.mle.parts.IMlePropPart;
import com.wizzer.mle.parts.j3d.props.I3dModelProperty;
import com.wizzer.mle.parts.roles.Mle3dModelCarrier;
import com.wizzer.mle.runtime.core.IMleObject;
import com.wizzer.mle.runtime.core.MleActor;
import com.wizzer.mle.runtime.core.MleMediaRef;
import com.wizzer.mle.runtime.core.MleRole;
import com.wizzer.mle.runtime.core.MleRuntimeException;

/**
 * Created by msm on 8/22/16.
 */
public class Mle3dModelProperty implements I3dModelProperty
{
    // The media reference managed by the property.
    private MleMediaRef m_model = null;

    /**
     * The default constructor.
     */
    public Mle3dModelProperty() { super(); }

    /**
     * Get the property value.
     *
     * @return A <code>MleMediaRef</code> is returned.
     */
    public MleMediaRef getProperty()
    {
        return m_model;
    }

    /**
     * Set the property value.
     *
     * @param reference This argument should be a <code>MleMediaRef</code>.
     */
    public void setProperty(MleMediaRef reference)
    {
        m_model = reference;
    }

    /* (non-Javadoc)
     * @see com.wizzer.mle.parts.props.IMlePropPart#push(com.wizzer.mle.runtime.core.IMleObject)
     */
    public boolean push(IMleObject obj)
            throws MleRuntimeException
    {
        boolean retValue = false;

        if (obj instanceof MleActor) {
            MleActor actor = (MleActor) obj;
            retValue = Mle3dModelCarrier.set(actor.getRole(), m_model);
        }

        return retValue;
    }

    /* (non-Javadoc)
     * @see com.wizzer.mle.parts.props.IMlePropPart#pull(com.wizzer.mle.runtime.core.IMleObject)
     */
    public boolean pull(IMleObject obj)
            throws MleRuntimeException
    {
        MleRole role = (MleRole) obj;

        return false;
    }

    /* (non-Javadoc)
     * @see com.wizzer.mle.parts.props.IMlePropPart#equals(com.wizzer.mle.parts.props.IMlePropPart)
     */
    public boolean equals(IMlePropPart property)
    {
        boolean retValue = false;

        if (property instanceof Mle3dModelProperty)
        {
            Mle3dModelProperty tmp = (Mle3dModelProperty)property;
            if (tmp.m_model.equals(this.m_model))
                retValue = true;
        }

        return retValue;
    }
}
