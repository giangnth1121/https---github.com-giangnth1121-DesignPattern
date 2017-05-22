package com.example.tuanjio.mvcexample.viper.routing;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.tuanjio.mvcexample.mvc.login.InfoActivity;
import com.example.tuanjio.mvcexample.viper.view.LoginActivityViper;

/**
 * Created by TuanJio on 5/18/2017.
 */
/*layer này chỉ thực hiện khởi tạo các màn hình, và điều khiển việc hiển thị, dịch chuyển các màn hình.
* Routing: bao gồm logic chuyển đổi giữa các màn hình với nhau theo thứ tự thiết kế trước.
*  xử lý các animation.
* */
public class RoutingLogin {
    LoginActivityViper mRouting;
    Context mContext;

    public RoutingLogin(Context context) {
        mContext = context;
    }

    public void sangManHinhInfo() {
        Intent intent = new Intent(mContext, InfoActivity.class);
        mContext.startActivity(intent);
    }

    public void onLoginFailed() {
        Toast.makeText(mRouting, "Thông tin bạn nhập chưa chính xác vui lòng nhập lại!", Toast.LENGTH_SHORT).show();
    }
}
