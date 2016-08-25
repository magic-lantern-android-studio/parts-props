package com.wizzer.mle.parts.props;

import com.wizzer.mle.math.MlScalar;
import com.wizzer.mle.math.MlTransform;
import com.wizzer.mle.math.MlRotation;
import com.wizzer.mle.parts.IMlePropPart;
import com.wizzer.mle.parts.roles.Mle3dTransformCarrier;
import com.wizzer.mle.runtime.core.IMleObject;
import com.wizzer.mle.runtime.core.MleActor;
import com.wizzer.mle.runtime.core.MleRole;
import com.wizzer.mle.runtime.core.MleRuntimeException;

/**
 * Created by msm on 8/25/16.
 */
public class Mle3dQuaternionRotationProperty implements IMlePropPart
{
    // The rotation managed by the property.
    private MlRotation m_rotation = null;

    public Mle3dQuaternionRotationProperty()
    {
        super();
        m_rotation = new MlRotation(MlScalar.ML_SCALAR_ZERO, MlScalar.ML_SCALAR_ZERO,
                MlScalar.ML_SCALAR_ZERO, MlScalar.ML_SCALAR_ONE);
    }

    /**
     * Get the property value.
     *
     * @return A <code>MlRotation</code> is returned.
     */
    public MlRotation getProperty()
    {
        return m_rotation;
    }

    /**
     * Set the property value.
     *
     * @param rotation This argument should be a <code>MlRotation</code>.
     */
    public void setProperty(MlRotation rotation)
    {
        m_rotation = rotation;
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

            MlTransform transform = new MlTransform();
            if (Mle3dTransformCarrier.get(actor.getRole(), transform)) {
                transform.setRotationOnly(m_rotation);

                retValue = Mle3dTransformCarrier.set(actor.getRole(), transform);
            }
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

        if (property instanceof Mle3dQuaternionRotationProperty)
        {
            Mle3dQuaternionRotationProperty tmp = (Mle3dQuaternionRotationProperty) property;
            if (tmp.m_rotation.equals(this.m_rotation))
                retValue = true;
        }

        return retValue;
    }
}
