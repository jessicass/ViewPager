package com.example.viewpager;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GuideActivity extends Activity implements OnClickListener,
		OnPageChangeListener {
	private ViewPager viewPager;
	private ViewPagerAdapter vpAdapter;
	private ArrayList<View> views;

	// ����ͼƬ��Դ
	private static final int[] pics = { R.drawable.guide1, R.drawable.guide2,
			R.drawable.guide3, R.drawable.guide4 };
	// �ײ�С���ͼƬ
	private ImageView[] points;

	// ��¼��ǰѡ��λ��
	private int currentIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);

		initView();
		initData();
	}

	/**
	 * ��ʼ�����
	 */
	private void initView() {
		views = new ArrayList<View>();
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		vpAdapter = new ViewPagerAdapter(views);
	}

	/**
	 * ��ʼ������
	 */
	private void initData() {
		// ����һ�����ֲ����ò���
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);

		// ��ʼ������ͼƬ�б�
		for (int i = 0; i < pics.length; i++) {
			ImageView imgView = new ImageView(this);
			imgView.setLayoutParams(mParams);
			imgView.setImageResource(pics[i]);
			views.add(imgView);
		}

		viewPager.setAdapter(vpAdapter);
		viewPager.setOnPageChangeListener(this);

		initPoint();
	}

	/**
	 * ��ʼ���ײ�С��
	 */
	private void initPoint() {
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
		points = new ImageView[pics.length];

		// ѭ��ȡ��С��ͼƬ
		for (int i = 0; i < pics.length; i++) {
			// �õ�һ��LinearLayout�����ÿһ����Ԫ��
			points[i] = (ImageView) linearLayout.getChildAt(i);
			// Ĭ�϶���Ϊ��ɫ
			points[i].setEnabled(true);
		}

		// ���õ���Ĭ�ϵ�λ��
		currentIndex = 0;
		// ����Ϊ��ɫ����ѡ��״̬
		points[currentIndex].setEnabled(false);
	}

	/**
	 * ������״̬�ı�ʱ����
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	/**
	 * ��ǰҳ�汻����ʱ����
	 */
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	/**
	 * ���µ�ҳ�汻ѡ��ʱ����
	 */
	@Override
	public void onPageSelected(int position) {
		if (position < 0 || position > pics.length - 1
				|| currentIndex == position) {
			return;
		}
		// ���õײ�С��ѡ��״̬
		setCurDot(position);
		// �����µ�ҳ��
		setCurView(position);
	}

	@Override
	public void onClick(View v) {

	}

	/**
	 * ���õ�ǰ��С���λ��
	 */
	private void setCurDot(int position) {
		points[position].setEnabled(false);
		points[currentIndex].setEnabled(true);

		currentIndex = position;
	}

	/**
	 * ���õ�ǰҳ���λ��
	 */
	private void setCurView(int position) {
		viewPager.setCurrentItem(position);
	}

}
