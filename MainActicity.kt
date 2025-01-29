package com.dshj.constdevelop

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 전체 화면 설정
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide() // 액션바 숨기기

        setContentView(R.layout.layout) // XML 레이아웃 사용

        val gridLayout: GridLayout = findViewById(R.id.gridLayout)

        val gridSize = 8
        val blockSize = 150
        val contentSize = 135
        val borderSize = 7

        // GridLayout의 행과 열 수 설정
        gridLayout.columnCount = gridSize
        gridLayout.rowCount = gridSize

        // 블록을 동적으로 추가
        for (i in 0 until gridSize) {
            for (j in 0 until gridSize) {
                // 각 GridLayout 셀 자체를 하나의 "블록"처럼 처리
                val block = FrameLayout(this)

                // GridLayout의 각 셀 위치 설정
                val layoutParams = GridLayout.LayoutParams()
                layoutParams.width = blockSize
                layoutParams.height = blockSize
                layoutParams.rowSpec = GridLayout.spec(i)
                layoutParams.columnSpec = GridLayout.spec(j)
                block.layoutParams = layoutParams

                // 배경 영역
                val background = View(this)
                val backgroundParams = FrameLayout.LayoutParams(contentSize, contentSize)
                background.setBackgroundColor(0xFF2e1a47.toInt()) // 어두운 보라색
                background.layoutParams = backgroundParams
                backgroundParams.leftMargin = borderSize
                backgroundParams.topMargin = borderSize

                // 테두리
                val border = View(this)
                val borderParams = FrameLayout.LayoutParams(blockSize, blockSize)
                border.setBackgroundColor(0xFF5a3e87.toInt()) // 연한 보라색
                border.layoutParams = borderParams

                // 배경을 먼저 추가하고, 그 위에 테두리 추가
                block.addView(border)
                block.addView(background)

                // 마지막 행과 마지막 열에 테두리가 잘 보이도록 추가 조정
                if (i == gridSize - 1) {
                    // 마지막 행: 아래쪽에 테두리 추가
                    borderParams.bottomMargin = borderSize
                }
                if (j == gridSize - 1) {
                    // 마지막 열: 오른쪽에 테두리 추가
                    borderParams.rightMargin = borderSize
                }

                // GridLayout에 블록 추가
                gridLayout.addView(block)
            }
        }
    }
}
