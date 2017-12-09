package com.travel_lover;

import android.util.FloatMath;
import android.util.Log;
import android.view.MotionEvent;

import com.nhnst.popcorn.layers.CCLayer;
import com.nhnst.popcorn.nodes.CCLabel;
import com.nhnst.popcorn.nodes.CCSprite;
import com.nhnst.popcorn.types.CGPoint;
import com.nhnst.popcorn.types.CGSize;

import static android.util.FloatMath.*;
import static java.lang.Math.sqrt;

public class MapLayer extends CCLayer{

    CCLabel lbl;
    CCLabel lbl2;
    CCSprite bg;
    CCSprite arrow;
    CCSprite mark;
	public enum MODE
	{
		NONE,DRAG,ZOOM,BIGGER,SMALLER
	};
    boolean flg =false;
    MODE mode=MODE.NONE;
    int touchCount;
	float start_x = 0.0f;
	float start_y = 0.0f;
	float map_x;
	float map_y;
	float start_scale=0.0f;
	float beforeLength=0.0f;
	float afterLength=0.0f;
	int screenH;
	int screenW;
	float mapW;
	float mapH;
    CGPoint posMin;
    CGPoint posMax;
    float scaleMax;
    float scaleMin;
	int i = 0;
    CGPoint startPoint;
    CGPoint startPosition;
    CGSize backgroundSize=new CGSize();
    CGPoint prePoint=CGPoint.zero();
    double latRate;//���ȱ���
    double longRate;//ά�ȱ���
    double refLat;	//�ο���ľ���
    double refLon;	//�ο���ľ���
    float refX;		//�ο���ĺ�����
    float refY;		//�ο����������
	public MapLayer(int width,int height,String backImage){
		super();
		this.setIsTouchEnabled(true);
//		���ñ���ͼƬ
		setBackgroundMap(backImage);
//		����ָʾͼƬ
		arrow = CCSprite.sprite("arrow.png");
		arrow.setPosition(CGPoint.ccp(50, 50));
		this.addChild(arrow,1);
//		���ñ��ͼƬ
//		mark = CCSprite.sprite("blocks.png");
//		mark.setPosition(CGPoint.ccp(0, 0));
//		this.addChild(mark,1);
//		
		screenH=height;
		screenW=width;
		Log.d("DEBUG","screenH = "+screenH + " screenW " +screenW);
	    backgroundSize.width = bg.getContentSize().width;
	   // backgroundSize.height = 640;
	    
//	    CGSize winSize = CCDirector.sharedDirector().winSize();
	    CGSize winSize = CGSize.make(screenH, screenW);
	    Log.d("DEBUG","height = "+winSize.height+ " width = "+winSize.width);
	    backgroundSize.height = backgroundSize.width * winSize.height / winSize.width;
	    
	    scaleMax = 2.0f;
	    float wscale=winSize.width / backgroundSize.width;
	    float hscale=winSize.height/backgroundSize.height;
	    scaleMin = wscale<hscale?wscale:hscale;
	    
	    this.setAnchorPoint(CGPoint.zero());
	    this.setScale(1.f);
	    this.setPosition(CGPoint.ccp(winSize.width / 2.f, winSize.height / 2.f));
	    //������ʱ����ʱִ��test��������ʱ����ָ������λ�á�
	    //FIXME:���ʹ��GPS���˴���Ҫע�͵�
	    schedule("test", 0.5f);
	}
//	���ñ���ͼƬ
	public void setBackgroundMap(String mapname)
	{
		bg = CCSprite.sprite(mapname);
		bg.setPosition(CGPoint.ccp(0, 0));
		this.addChild(bg,0);
		mapW=bg.getContentSize().getWidth();
		mapH=bg.getContentSize().getHeight();	
	}
	public void test(float dt) 
	{
//		ѭ���ƶ�ָ��ͼ�����ڵ�λ�á�
//		�����п��Զ�ʱ��ȡGPSλ�ý���ת��Ϊ��ǰ�û����ڵ�λ��
		Log.d("DEBUG", " ii = " + i++);
		if(arrow.getPosition().x<480)
			arrow.setPosition(arrow.getPosition().x+20,arrow.getPosition().y);
		else
			arrow.setPosition(2,arrow.getPosition().y);
		Log.d("DEBUG","x= "+arrow.getPosition().x);
	}
	//���þ�γ�ȱ���
	public void setRate(double lat,double lon)
	{
		latRate=lat;
		longRate=lon;
	}
	//���òο���
	public void setReferencePoint(double lat,double lon,float xpos,float ypos)
	{
		refLat=lat;
		refLon=lon;
		refX=xpos;
		refY=ypos;
	}
	//���õ�ǰָ�����ڵ�λ��
	public void setCurrentPosition(double lat,double lon)
	{
		  Log.d("DEBUG", "Lan = "+lat+ " long = "+lon);
		  //TODO:
		  arrow.setPosition((float)(refX+(lat-refLat)/latRate),(float)(refY+(lon-refLon)*longRate));
	}
	
    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) sqrt(x * x + y * y);
    }
    CGPoint screenToCocos(float x,float y)
    {
    	return CGPoint.ccp(x,screenH - y);
    }
    @Override
	public void setPosition(CGPoint pos)
    {
        if (pos.x > posMax.x)
            pos.x = posMax.x;
        else if (pos.x < posMin.x)
            pos.x = posMin.x;
        
        if (pos.y > posMax.y)
            pos.y = posMax.y;
        else if (pos.y < posMin.y)
            pos.y = posMin.y;
        
        super.setPosition(pos);
    }
    @Override
    public void setScale(float value)
    {
    	if (value < scaleMin) 
            value = scaleMin;
        else if (value > scaleMax) 
            value = scaleMax;
        super.setScale(value);
        
        CGSize winSize = CGSize.make(screenH, screenW);
        CGPoint centerPos = CGPoint.ccp(winSize.width * 0.5f, winSize.height * 0.5f);
        CGPoint scaledPos = CGPoint.ccp((backgroundSize.width * value - winSize.width) * 0.5f, 
                                (backgroundSize.height * value - winSize.height) * 0.5f);
        posMin = CGPoint.ccpSub(centerPos, scaledPos);
        posMax = CGPoint.ccpAdd(centerPos, scaledPos);
        
        this.setPosition(this.getPosition());
    }
    //��������Ϣ
    public boolean ccTouchesBegan(MotionEvent event)
    {
        int touchCount = event.getPointerCount();
        if (touchCount == 1) {
            startPoint = CGPoint.ccp(event.getX(), event.getY());
            startPosition = this.getPosition();
        } else if (touchCount == 2){
        	beforeLength = spacing(event);
        	Log.d("DEBUG", "ccTouchesBegan beforeLength = " + beforeLength);
        	start_scale=this.getScale();
        }
        return super.ccTouchesBegan(event);
    }

    public boolean ccTouchesMoved(MotionEvent event)
    {
    	int touchCount = event.getPointerCount();
        if (touchCount == 1 ) {
        	CGPoint curPoint=CGPoint.ccp(event.getX(), event.getY());
            CGPoint posDiff = CGPoint.ccpSub(curPoint, startPoint);		//CGPoint.ccp(curPoint.x-startPoint.x, curPoint.y-startPoint.y);
            posDiff.y=-posDiff.y;
            this.setPosition(CGPoint.ccpAdd(startPosition, posDiff));
        }
        else if (touchCount == 2)
        {
        	afterLength = spacing(event);
        	float curScale=start_scale*afterLength/beforeLength;
        	Log.d("DEBUG", "ccTouchesMoved start scale = "+ start_scale + "  curScale = " + curScale);
        	Log.d("DEBUG", "ccTouchesMoved afterLength = "+ afterLength + " beforeLength = " + beforeLength);
        	this.setScale(curScale);
        }
        return super.ccTouchesMoved(event);
    }
    
    public boolean ccTouchesEnded(MotionEvent event)
    {
        if (event.getPointerCount() == 1) {
            startPoint = CGPoint.ccp(event.getX(), event.getY());
            startPosition = this.getPosition();
            Log.d("DEBUG", "ccTouchesEnded startPosition = "+ startPosition + "startPoint = " + startPoint);
        }
        return super.ccTouchesEnded(event);
    }

    public boolean ccTouchesCancelled(MotionEvent event)
    {
    	return super.ccTouchesCancelled(event);
    }
}