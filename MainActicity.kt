package com.dshj.constdevelop

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 전체 화면 설정
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide() // 액션바 숨기기

        setContentView(R.layout.layout) // 위 XML 레이아웃을 사용

        val gridLayout: GridLayout = findViewById(R.id.gridLayout)

        val blockSize = 150
        val contentSize = 135
        val borderSize = 15

        // GridLayout의 행과 열 수 설정 (80x80)
        gridLayout.columnCount = 80
        gridLayout.rowCount = 80

        // 블록을 동적으로 추가
        for (i in 0 until 80) {
            for (j in 0 until 80) {
                // FrameLayout으로 테두리와 배경을 포함하는 블록 생성
                val block = FrameLayout(this)
                val layoutParams = GridLayout.LayoutParams()
                layoutParams.width = blockSize
                layoutParams.height = blockSize
                block.layoutParams = layoutParams

                // 배경 영역 (45x45)
                val background = View(this)
                val backgroundParams = FrameLayout.LayoutParams(contentSize, contentSize)
                background.setBackgroundColor(0xFF2e1a47.toInt())
                /*
                #243b2e
                #2e1a47
                #5a3e87
                #4a7358
                #0d0d0d
                */
                background.layoutParams = backgroundParams

                // 배경을 FrameLayout 안에 위치시키기 (테두리를 제외한 공간)
                backgroundParams.leftMargin = borderSize
                backgroundParams.topMargin = borderSize

                // 테두리 (50x50)
                val border = View(this)
                val borderParams = FrameLayout.LayoutParams(blockSize, blockSize)
                border.setBackgroundColor(0xFF5a3e87.toInt())
                border.layoutParams = borderParams

                // 배경을 먼저 추가하고, 그 위에 테두리 추가
                block.addView(border)  // 테두리 먼저 추가
                block.addView(background)  // 배경 추가

                // GridLayout에 블록 추가
                gridLayout.addView(block)
            }
        }
    }
}
