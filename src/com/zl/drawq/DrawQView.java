package com.zl.drawq;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 贝塞尔曲线
 * @author zhanglong
 *
 */
public class DrawQView extends View{
	
	/**绘制贝塞尔曲线的画笔*/
	private Paint mPaint;
	
	/** 贝赛尔曲线成员变量(起始点，控制（操作点），终止点，3点坐标)*/
	private int startX, startY, controlX, controlY, endX, endY;
	
	/**绘制Path*/
	private Path mPath;
	

	public DrawQView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		//画笔初始化
		mPaint = new Paint();
		mPaint.setColor(Color.BLACK);
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Style.STROKE);
		mPaint.setStrokeWidth(5);
		
		mPath = new Path();
		//初始化变量值
		startX = 0;
		startY = 400;
		endX = 400;
		endY = 400;
		controlX = 200;
		controlY = 200;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawPath(canvas);
	}
	
	/**
	 * 具体绘制
	 */
	private void drawPath(Canvas canvas){
		// 重置mPath
		mPath.reset();
		// 贝赛尔曲线的起始点
		mPath.moveTo(startX, startY);
		// 设置贝赛尔曲线的操作点以及终止点
		mPath.quadTo(controlX, controlY, endX, endY);
		// 绘制贝赛尔曲线（Path）
		canvas.drawPath(mPath, mPaint);
	}

}
