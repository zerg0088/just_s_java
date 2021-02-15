package fast.sjcompany.test;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton moreButton;
    private double buttonWidth = 57.5;
    private ScrollView scrollview;
    private TableLayout tl;

    private String specialString = "§ ※ ☆ ★ ○ ● ◎ ◇ ◆ □ ■ △ ▲ ▽ ▼ → ← ← ↑ ↓ ↔ 〓 " +
            "◁ ◀ ▷ ▶ ♤ ♠ ♡ ♥ ♧ ♣ ⊙ ◈ ▣ ◐ ◑ ▒ ▤ ▥ ▨ ▧ ▦ ▩ ♨ ☏ ☎ ☜ ☞ ¶ † ‡ ↕ ↗ ↙ ↖ ↘ ♭ ♩ ♪ ♬ ㉿ ㈜ " +
            "№ ㏇ ™ ㏂ ㏘ ℡ ® ª º ─ │ ┌ ┐ ┘ └ ├ ┬ ┤ ┴ ┼ ━ ┃ ┏ ┓ ┛ ┗ ┣ ┳ ┫ ┻ ╋ ┠ ┯ ┨ ┷ ┿ ┝ ┰ ┥ ┸ ╂ ┒ " +
            "┑ ┚ ┙ ┖ ┕ ┎ ┍ ┞ ┟ ┡ ┢ ┦ ┧ ┩ ┪ ┭ ┮ ┱ ┲ ┵ ┶ ┹ ┺ ┽ ┾ ╀ ╁ ╃ ╄ ╅ ╆ ╇ ╈ ╉ ╊ " +
            "＋ － ＜ ＝ ＞ ± × ÷ ≠ ≤ ≥ ∞ ∴ ♂ ♀ ∠ ⊥ ⌒ ∂ ∇ ≡ ≒ ≪ ≫ √ ∽ ∝ ∵ ∫ ∬ ∈ ∋ ⊆ ⊇ ⊂ ⊃ ∪ ∩ ∧ ∨ ￢ ⇒ ⇔ ∀ ∃ ∮ ∑ ∏ " +
            "！ ＇ ， ． ／ ： ； ？ ＾ ＿ ｀ ｜ ￣ 、 。 · ‥ … ¨ 〃 ― ∥ ＼ ∼ ´ ～ ˇ ˘ ˝ ˚ ˙ ¸ ˛ ¡ ¿ ː " +
            "＂ ” 〔 〕 ｛ ｝ ‘ ’ “ ” 〔 〕 〈 〉 《 》 「 」 『 』 【 】 " +
            "㉠ ㉡ ㉢ ㉣ ㉤ ㉥ ㉦ ㉧ ㉨ ㉩ ㉪ ㉫ ㉬ ㉭ " +
            "㉮ ㉯ ㉰ ㉱ ㉲ ㉳ ㉴ ㉵ ㉶ ㉷ ㉸ ㉹ ㉺ ㉻ " +
            "㈀ ㈁ ㈂ ㈃ ㈄ ㈅ ㈆ ㈇ ㈈ ㈉ ㈊ ㈋ ㈌ ㈍ " +
            "㈎ ㈏ ㈐ ㈑ ㈒ ㈓ ㈔ ㈕ ㈖ ㈗ ㈘ ㈙ ㈚ ㈛ " +
            "ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ⓘ ⓙ ⓚ ⓛ ⓜ ⓝ ⓞ ⓟ ⓠ ⓡ ⓢ ⓣ ⓤ ⓥ ⓦ ⓧ ⓨ ⓩ " +
            "⒜ ⒝ ⒞ ⒟ ⒠ ⒡ ⒢ ⒣ ⒤ ⒥ ⒦ ⒧ ⒨ ⒩ ⒪ ⒫ ⒬ ⒭ ⒮ ⒯ ⒰ ⒱ ⒲ ⒳ ⒴ ⒵ " +
            "① ② ③ ④ ⑤ ⑥ ⑦ ⑧ ⑨ ⑩ ⑪ ⑫ ⑬ ⑭ ⑮ " +
            "⑴ ⑵ ⑶ ⑷ ⑸ ⑹ ⑺ ⑻ ⑼ ⑽ ⑾ ⑿ ⒀ ⒁ ⒂ " +
            "あ い う え お か き く け こ さ し す せ そ た ち つ て と な に ぬ ね の は ひ ふ へ ほ ま み む め も や ゆ よ ゃ ゅ ょ ら り る れ ろ わ ゐ ゑ を ん が ぎ ぐ げ ご ざ じ ず ぜ ぞ だ ぢ づ で ど ば び ぶ べ ぼ ぱ ぴ ぷ ぺ ぽ ア イ ウ エ オ カ キ ク ケ コ サ シ ス セ ソ タ チ ツ テ ト ナ 二 ヌ ネ ノ ハ ヒ フ ヘ ホ マ ミ ム メ モ ヤ ユ ヨ ャ ュ ョ ラ リ ル レ ロ ワ ヰ ヱ ヲ ン ガ ギ グ ゲ ゴ ザ ジ ズ ゼ ゾ ダ ヂ ヅ デ ド バ ビ ブ ベ ボ パ ピ プ ペ ポ";

    private ArrayList<SButton> buttonList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moreButton = findViewById(R.id.moreButton);
        scrollview = findViewById(R.id.scrollview);
        tl = findViewById(R.id.mainTableLayout);
        String[] str = specialString.split(" ");

        for(int i = 0;i < Math.ceil(str.length/5.0) ;i++) {
            TableRow row = new TableRow(MainActivity.this);
            for (int j = 0; j < 5; j++) {
                final int index = i * 5 + j;
                if(index < str.length) {
                    SButton sButton = new SButton(MainActivity.this);
                    String s = str[i * 5 + j] + "\uFE0E";
                    sButton.setText(s);
                    row.addView(sButton);

                    sButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                            ClipData clipData = ClipData.newPlainText("label", str[index]);
                            clipboardManager.setPrimaryClip(clipData);
                            Toast.makeText(MainActivity.this, str[index]+ " 문자가 복사되었습니다.", Toast.LENGTH_LONG).show();
                            //sButton.opacityAnimationStart(10,0);
                            //finish();
                        }
                    });
                    sButton.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                                sButton.setGreenBackground(true);
                            } else if(event.getAction() == MotionEvent.ACTION_UP) {
                                //sButton.setGreenBackground(false);
                                sButton.opacityAnimationStart(300,0);
                            } else if(event.getAction() == MotionEvent.ACTION_CANCEL) {
                                sButton.setGreenBackground(false);
                            }
                            return false;
                        }
                    });
                    buttonList.add(sButton);
                }
            }
            tl.addView(row);
        }
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onPopupButtonClick(v);
                initiatePopupWindow();
            }
        });

    }

    private PopupWindow mDropdown = null;
    private PopupWindow initiatePopupWindow() {
        try {
            LayoutInflater mInflater = (LayoutInflater) getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = mInflater.inflate(R.layout.popup, null);

            final Button info = (Button) layout.findViewById(R.id.infoButton);
            final Button series = (Button) layout.findViewById(R.id.seriesButton);

            layout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            mDropdown = new PopupWindow(layout, FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT,true);

            mDropdown.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            mDropdown.setElevation(40);
            mDropdown.showAsDropDown(moreButton, -1 * (int)dpToPixel(50) - (int)dpToPixel(18), -1 * (int)dpToPixel(62) + (int)dpToPixel(18));

            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                    startActivity(intent);
                }
            });

            series.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent intent = new Intent(MainActivity.this, SeriesActivity.class);
                    //startActivity(intent);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Justfolks&hl=en_US")));
                    //
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDropdown;
    }

    private float dpToPixel(float dp) {
        Resources resources = this.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }
}
