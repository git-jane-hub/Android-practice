package org.ict.movieprj.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.ict.movieprj.R;
import org.ict.movieprj.vo.DailyBoxOffice;

import java.util.List;

// RecyclerView의 Adapter 관련 내용을 정의하는 클래스로
// RecyclerView 클래스 내부의 Adapter를 상속해 만듦
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    // 반복해서 View 로 나타내줄 요소 선언
    List<DailyBoxOffice> items;

    // 생성자에 View 로 나타내줄 요소를 입력해야만 실행되도록 파라미터를 처리
    public MovieAdapter(List<DailyBoxOffice> items){
        this.items = items;
    }

    // Override Methods를 활용해 onCreateViewHolder를 선언
    // layou폴더 내부에 있는 RecyclerView의 본체로 활용될 현 프로젝트의 card.xml을 참조
    // 여기서의 ViewHolder는 card.xml을 의미함
    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(itemView);
    }

    // 특정한 형식에 데이터를 넣는 것을 binding이라함
    // 위에서 불러온 card.xml 내부의 카드마다 DailyBoxOffice에 해당하는 영화정보를 붙여줘야함
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // holder에 각각 영화 정보를 바인딩
        DailyBoxOffice item = items.get(position);
        holder.setItem(item);
    }

    // 출력할 영화 개수 체크
    public int getItemCount(){
        return items.size();
    }

    // 클래스의 내부에 ViewHolder 클래스 선언, TextView 3개에 대한 설정을 할 수 있도록 처리
    public static class ViewHolder extends RecyclerView.ViewHolder{
        // card.xml 내부 위젯
        private TextView rankNum, mTitle, mDate;

        // 생성자에 card.xml 내부 위젯을 연결
        public ViewHolder(View itemView){
            super(itemView);
            rankNum = itemView.findViewById(R.id.rankNum);
            mTitle = itemView.findViewById(R.id.mTitle);
            mDate = itemView.findViewById(R.id.mDate);
        }

        // 연결된 위젯의 텍스트 세팅
        public void setItem(DailyBoxOffice item){
            rankNum.setText(item.getRank() + "위");
            mTitle.setText("영화 제목: " + item.getMovieNm());
            mDate.setText("개봉일: " + item.getOpenDt());
        }
    }
}
