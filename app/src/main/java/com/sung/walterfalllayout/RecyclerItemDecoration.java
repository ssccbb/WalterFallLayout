package com.sung.walterfalllayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sung on 2018/2/7.
 */

public class RecyclerItemDecoration extends RecyclerView.ItemDecoration {
    private int dividerHeight;
    private Paint dividerPaint;
    private boolean fullOffSet = false;

    public RecyclerItemDecoration(Context context, int resColorId, int resDimenHeightId, boolean fullOffSet) {
        this.fullOffSet = fullOffSet;
        dividerPaint = new Paint();
        if (context != null) {
            dividerPaint.setColor(context.getResources().getColor(resColorId));
            dividerHeight = context.getResources().getDimensionPixelSize(resDimenHeightId);
        } else {
            dividerPaint.setColor(Color.parseColor("#00f2f2f2"));
            dividerHeight = 5;
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        super.getItemOffsets(outRect, itemPosition, parent);
        outRect.top = dividerHeight;
        if (fullOffSet) {
            outRect.left = dividerHeight / 2;
            outRect.right = dividerHeight / 2;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + dividerHeight;
            c.drawRect(left, top, right, bottom, dividerPaint);
        }
    }
}
