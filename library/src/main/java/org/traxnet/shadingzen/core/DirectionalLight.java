package org.traxnet.shadingzen.core;

import org.traxnet.shadingzen.math.BBox;
import org.traxnet.shadingzen.math.Vector3;

public class DirectionalLight extends Actor implements LightEmitter {
	protected ShadowCastingType _shadowCastingType = ShadowCastingType.HARD_SHADOWMAP;
	protected float _lightingRange = 1.f;
	protected float _lightingIntesity = 1.f;
	protected float[] _lightingColor = new float[4];
	protected Vector3 _lightingDirection = new Vector3(1.f, 1.f, 1.f);
	protected float _lightingFov = 0.f;

	public DirectionalLight(){
		
	}


    public void setValues(float dir_x, float dir_y, float dir_z, float fov, float intensity){
		_lightingDirection.set(dir_x, dir_y, dir_z);
		_lightingFov = fov;
		_lightingIntesity = intensity;
	}
	
	public void setColor(float r, float g, float b){
		_lightingColor[0] = r;
        _lightingColor[1] = g;
        _lightingColor[2] = b;
        _lightingColor[3] = 1.f;
	}

	@Override
	public ShadowCastingType getShadowCastingType() {
		return _shadowCastingType;
	}
	
	public void setShadowCastingType(ShadowCastingType type){
		_shadowCastingType = type;
	}

	@Override
	public float computeContributionAtWorldPoint(float x, float y, float z) {
		float x_diff = (x - _position.getX());
		float y_diff = (y - _position.getY());
		float z_diff = (z - _position.getZ());
		
		float length = x_diff*x_diff + y_diff*y_diff + z_diff*z_diff;
		
		float ret = _lightingIntesity/length;
		if(ret <= 0.001f)
			return 0.f;
		
		return ret;
	}

    @Override
    public float[] getLightColor() {
        return _lightingColor;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public float[] getLightPosition() {
        return _position.getAsArray();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
	protected void onUpdate(float deltaTime) {
		// Put your animated lighting effect here 
		
	}

	@Override
	public void onDraw(RenderService renderer) throws Exception {
		// Would be a good place to render a flare effect
		
	}

	@Override
	public void onLoad() {
		
		
	}

	@Override
	public void onUnload() {
		
		
	}

}
