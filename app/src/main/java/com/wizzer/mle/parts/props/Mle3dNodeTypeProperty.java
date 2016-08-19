/*
 * MleImageProperty.java
 * Created on Feb 23, 2005
 */

// COPYRIGHT_BEGIN
//
//  Copyright (C) 2000-2007  Wizzer Works
//
//  Wizzer Works makes available all content in this file ("Content").
//  Unless otherwise indicated below, the Content is provided to you
//  under the terms and conditions of the Common Public License Version 1.0
//  ("CPL"). A copy of the CPL is available at
//
//      http://opensource.org/licenses/cpl1.0.php
//
//  For purposes of the CPL, "Program" will mean the Content.
//
//  For information concerning this Makefile, contact Mark S. Millard,
//  of Wizzer Works at msm@wizzerworks.com.
//
//  More information concerning Wizzer Works may be found at
//
//      http://www.wizzerworks.com
//
// COPYRIGHT_END

// Declare package.
package com.wizzer.mle.parts.props;

// Import Magic Lantern Runtime Engine classes.
import com.wizzer.mle.runtime.core.IMleObject;
import com.wizzer.mle.runtime.core.MleActor;
import com.wizzer.mle.runtime.core.MleRole;
import com.wizzer.mle.runtime.core.MleRuntimeException;

// Import Magic Lantern Parts classes.
import com.wizzer.mle.parts.j3d.props.I3dNodeTypeProperty;
import com.wizzer.mle.parts.IMlePropPart;
import com.wizzer.mle.parts.roles.Mle3dNodeTypeCarrier;

/**
 * This class implements an 3d node property.
 * 
 * @author Mark S. Millard
 */
public class Mle3dNodeTypeProperty implements I3dNodeTypeProperty
{
    // The node type managed by the property.
    public I3dNodeTypeProperty.NodeType m_nodeType;

    /**
     * The default constructor.
     * <p>
     * The node type is set to TRANSFORM by default.
     * </p>
     */
    public Mle3dNodeTypeProperty()
    {
        super();
        m_nodeType = I3dNodeTypeProperty.NodeType.TRANSFORM;
    }
    
    /**
     * Get the property value.
     * 
     * @return A <code>I3dNodeTypeProperty.NodeType</code> is returned.
     */
    public I3dNodeTypeProperty.NodeType getProperty()
    {
        return m_nodeType;
    }
    
    /**
     * Set the property value.
     * 
     * @param nodeType This argument should be a <code>I3dNodeTypeProperty.NodeType</code>.
     */
    public void setProperty(I3dNodeTypeProperty.NodeType nodeType)
    {
    	m_nodeType = nodeType;
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
            retValue = Mle3dNodeTypeCarrier.set(actor.getRole(), m_nodeType);
        }
        
        return retValue;
    }

    /* (non-Javadoc)
     * @see com.wizzer.mle.parts.props.IMlePropPart#pull(com.wizzer.mle.runtime.core.IMleObject)
     */
    public boolean pull(IMleObject obj)
        throws MleRuntimeException
    {
        boolean retValue = false;

        if (obj instanceof MleRole) {
            MleRole role = (MleRole) obj;
            I3dNodeTypeProperty.NodeType value[] = new I3dNodeTypeProperty.NodeType[1];
            retValue = Mle3dNodeTypeCarrier.get(role, value);
            if (retValue == true) m_nodeType = value[0];
        }

        return retValue;
    }

    /* (non-Javadoc)
     * @see com.wizzer.mle.parts.props.IMlePropPart#equals(com.wizzer.mle.parts.props.IMlePropPart)
     */
    public boolean equals(IMlePropPart property)
    {
        boolean retValue = false;
        
        if (property instanceof Mle3dNodeTypeProperty)
        {
            Mle3dNodeTypeProperty tmp = (Mle3dNodeTypeProperty)property;
            if (m_nodeType.equals(tmp.m_nodeType))
                retValue = true;
        }
        
        return retValue;
    }
}
