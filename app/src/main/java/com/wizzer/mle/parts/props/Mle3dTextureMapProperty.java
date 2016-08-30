package com.wizzer.mle.parts.props;

import com.wizzer.mle.runtime.core.IMleObject;
import com.wizzer.mle.runtime.core.MleActor;
import com.wizzer.mle.runtime.core.MleMediaRef;
import com.wizzer.mle.runtime.core.MleRole;
import com.wizzer.mle.runtime.core.MleRuntimeException;

import com.wizzer.mle.parts.IMlePropPart;
import com.wizzer.mle.parts.roles.Mle3dTextureMapCarrier;

/**
 * Created by msm on 8/30/16.
 */
public class Mle3dTextureMapProperty implements IMlePropPart
{
    // The media reference managed by the property.
    private MleMediaRef m_textureMap = null;

    /**
     * The default constructor.
     */
    public Mle3dTextureMapProperty()
    {
        super();
    }

    /**
     * Get the property value.
     *
     * @return A <code>MleMediaRef</code> is returned.
     */
    public MleMediaRef getProperty()
    {
        return m_textureMap;
    }

    /**
     * Set the property value.
     *
     * @param reference This argument should be a <code>MleMediaRef</code>.
     */
    public void setProperty(MleMediaRef reference)
    {
        m_textureMap = reference;
    }

    /* (non-Javadoc)
     * @see com.wizzer.mle.parts.props.IMlePropPart#push(com.wizzer.mle.runtime.core.IMleObject)
     */
    public boolean push(IMleObject obj)
            throws MleRuntimeException
    {
        boolean retValue;

        MleActor actor = (MleActor) obj;
        retValue = Mle3dTextureMapCarrier.set(actor.getRole(), m_textureMap);

        return retValue;
    }

    /* (non-Javadoc)
     * @see com.wizzer.mle.parts.props.IMlePropPart#pull(com.wizzer.mle.runtime.core.IMleObject)
     */
    public boolean pull(IMleObject obj)
            throws MleRuntimeException
    {
        MleRole role = (MleRole) obj;

        // ToDo: not implemented.

        return false;
    }

    /* (non-Javadoc)
     * @see com.wizzer.mle.parts.props.IMlePropPart#equals(com.wizzer.mle.parts.props.IMlePropPart)
     */
    public boolean equals(IMlePropPart property)
    {
        boolean retValue = false;

        if (property instanceof Mle3dTextureMapProperty)
        {
            Mle3dTextureMapProperty tmp = (Mle3dTextureMapProperty)property;
            if (tmp.m_textureMap.equals(this.m_textureMap))
                retValue = true;
        }

        return retValue;
    }
}
