package com.wizzer.mle.parts.props;

import com.wizzer.mle.math.MlScalar;
import com.wizzer.mle.math.MlTransform;
import com.wizzer.mle.math.MlVector3;
import com.wizzer.mle.parts.IMlePropPart;
import com.wizzer.mle.parts.roles.Mle3dTransformCarrier;
import com.wizzer.mle.runtime.core.IMleObject;
import com.wizzer.mle.runtime.core.MleActor;
import com.wizzer.mle.runtime.core.MleRole;
import com.wizzer.mle.runtime.core.MleRuntimeException;

/**
 * Created by msm on 8/25/16.
 */
public class Mle3dNonuniformScaleProperty implements IMlePropPart
{
    // The translation managed by the property.
    private MlVector3 m_scale = null;

    public Mle3dNonuniformScaleProperty()
    {
        super();
        m_scale = new MlVector3(MlScalar.ML_SCALAR_ONE, MlScalar.ML_SCALAR_ONE, MlScalar.ML_SCALAR_ONE);
    }

    /**
     * Get the property value.
     *
     * @return A <code>MlVector3</code> is returned.
     */
    public MlVector3 getProperty()
    {
        return m_scale;
    }

    /**
     * Set the property value.
     *
     * @param scale This argument should be a <code>MlVector3</code>.
     */
    public void setProperty(MlVector3 scale)
    {
        m_scale = scale;
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
                transform.setScaleOnly(m_scale);

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

        if (property instanceof Mle3dNonuniformScaleProperty)
        {
            Mle3dNonuniformScaleProperty tmp = (Mle3dNonuniformScaleProperty) property;
            if (tmp.m_scale.equals(this.m_scale))
                retValue = true;
        }

        return retValue;
    }
}
