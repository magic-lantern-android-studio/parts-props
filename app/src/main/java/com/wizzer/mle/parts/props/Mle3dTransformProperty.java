package com.wizzer.mle.parts.props;

import com.wizzer.mle.math.MlTransform;
import com.wizzer.mle.runtime.core.IMleObject;
import com.wizzer.mle.runtime.core.MleActor;
import com.wizzer.mle.runtime.core.MleRole;
import com.wizzer.mle.runtime.core.MleRuntimeException;
import com.wizzer.mle.parts.IMlePropPart;
import com.wizzer.mle.parts.roles.Mle3dTransformCarrier;

/**
 * Created by msm on 8/25/16.
 */
public class Mle3dTransformProperty
{
    // The transform managed by the property.
    private MlTransform m_transform = null;

    public Mle3dTransformProperty()
    {
        super();
        m_transform = MlTransform.identity();
    }

    /**
     * Get the property value.
     *
     * @return A <code>MlTransform</code> is returned.
     */
    public MlTransform getProperty()
    {
        return m_transform;
    }

    /**
     * Set the property value.
     *
     * @param transform This argument should be a <code>MlTransform</code>.
     */
    public void setProperty(MlTransform transform)
    {
        m_transform = transform;
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
            retValue = Mle3dTransformCarrier.set(actor.getRole(), m_transform);
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

        // ToDo: implement something here.

        return false;
    }

    /* (non-Javadoc)
     * @see com.wizzer.mle.parts.props.IMlePropPart#equals(com.wizzer.mle.parts.props.IMlePropPart)
     */
    public boolean equals(IMlePropPart property)
    {
        boolean retValue = false;

        if (property instanceof Mle3dTransformProperty)
        {
            Mle3dTransformProperty tmp = (Mle3dTransformProperty) property;
            if (tmp.m_transform.equals(this.m_transform))
                retValue = true;
        }

        return retValue;
    }
}
