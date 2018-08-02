package linh.vn.androidcustommonthcalendar;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MonthOfYear extends LinearLayout {
    private OnMonthSelectedListener onMonthSelectedListener;

    private String[] monthOfYears = new String[]{"J", "F", "M", "A", "M", "June", "Junly", "A", "N", "O", "D", "N"};

    public MonthOfYear(Context context) {
        super(context, null);
    }

    public MonthOfYear(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MonthOfYear(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
        addYear();
    }

    public void setOnMonthSelectedListener(OnMonthSelectedListener onMonthSelectedListener) {
        this.onMonthSelectedListener = onMonthSelectedListener;
    }

    public void highlight(int i) {
        findViewById(i - 1).setBackgroundColor(Color.YELLOW);
    }

    public void addYear() {
        LinearLayout linearLayout1 = new LinearLayout(getContext());
        for (int i = 0; i < 6; i++) {
            linearLayout1.addView(createMonthItem(i));
        }

        LinearLayout linearLayout2 = new LinearLayout(getContext());
        for (int i = 6; i < 12; i++) {
            linearLayout2.addView(createMonthItem(i));
        }

        addView(linearLayout1);
        addView(linearLayout2);
    }

    private View createMonthItem(int i) {
        View itemMonth = LayoutInflater.from(getContext()).inflate(R.layout.item_month, this, false);
        itemMonth.setId(i);
        TextView textMonthNumber = itemMonth.findViewById(R.id.text_month_number);
        TextView textMonthName = itemMonth.findViewById(R.id.text_month_name);

        textMonthNumber.setText(String.valueOf(i + 1));
        textMonthName.setText(monthOfYears[i]);
        final int finalI = i;
        itemMonth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMonthSelectedListener != null) {
                    onMonthSelectedListener.onMonthSelected(finalI);
                }
            }
        });
        return itemMonth;
    }

    interface OnMonthSelectedListener {
        void onMonthSelected(int month);
    }
}
