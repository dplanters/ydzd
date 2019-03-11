/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.api;

import com.gndc.common.constant.Constant;
import com.gndc.common.enums.common.CountryType;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 返回码枚举
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @date 2018年1月25日 上午9:50:55
 * @version V1.0.1
 */

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月27日 下午3:47:49
 */
public enum ResultCode {
    // 成功
    OK(0, "成功", "Berhasil", "Thành công", "Success"),
    // 失败
    ERROR(-1, "失败", "Gagal", "Không thành công", "Failed"),
    // 失败
    SERVICE_ERROR(-2, "无法连接服务", "Tidak dapat terhubung ke layanan", "Không thể kết nối với dịch vụ",
            "Unable to connect to service"),
    // 系统繁忙
    EXCEPTION(-99, "系统繁忙", "Sistem sibuk", "Hệ thống đang bận", "The system is busy"),
    // 登录失败
    LOGIN_FAILED(-10, "登录失败", "Gagal masuk", "Đăng nhập thất bại", "Login failed"),
    // 请求头为空
    HEADER_ISNULL(-100, "请求头为空", "Request header kosong", "Tiêu đề yêu cầu trống", "Blank request"),
    // 功能号为空
    ACTION_ISNULL(-101, "功能号为空", "Function code kosong", "Số chức năng trống", "Blank function code"),
    // 用户信息为空
    USERID_ISNULL(-102, "用户信息为空", "Informasi pengguna kosong", "Thông tin người dùng trống", "Blank user information"),
    // 设备类型为空
    DEVICETYPE_ISNULL(-103, "设备类型为空", "Jenis peralatan kosong", "Loại thiết bị trống", "Blank device type"),
    // 消息类型为空
    MSGTYPE_ISNULL(-104, "消息类型为空", "Jenis informasi kosong", "Loại tin nhắn trống", "Blank message type"),
    // 用户未登录
    SESSIONID_ISNULL(-105, "用户未登录", "Pengguna belum masuk", "Người dùng chưa đăng nhập", "Not login yet"),
    // 分页参数为空
    PAGE_ISNULL(-106, "分页参数为空", "Paging parameter kosong", "Thông số phân trang trống", "Blank paging parameter"),
    // 缺少必要参数
    PARAM_MISSING(-107, "缺少必要参数", "Kekurangan parameter yang diperlukan", "Thiếu thông số cần thiết",
            "Necessary parameters missing"),
    // 无效功能号
    INVALID_ACTION(-111, "无效功能号", "Function code tidak valid", "Số hàm số không hợp lệ", "Unvalid founction code"),
    // 用户信息错误
    INVALID_USERID(-112, "用户信息错误", "Informasi pengguna salah", "Lỗi thông tin người dùng", "Wrong user's information"),
    // 无效设备类型
    INVALID_DEVICETYPE(-113, "无效设备类型", "Jenis peralatan tidak valid", "Loại thiết bị không hợp lệ",
            "Unvalid device type"),
    // 无效消息体
    INVALID_MSGTYPE(-114, "无效消息体", "Bodi pesan tidak valid", "Nội dung thư không hợp lệ", "Unvalid message"),
    // 用户不存在
    USER_NOT_EXISTS(-122, "用户不存在", "Pengguna tidak ada", "Người dùng không tồn tại", "The user doesn't exist"),
    // 用户已存在
    USER_EXISTS(-123, "用户已存在", "Pengguna telah ada", "Người dùng đã tồn tại", "The user existed already "),
    // 参数错误
    PARAMETER_ERROR(-124, "参数错误", "Parameter salah", "Lỗi tham số", "Wrong parameter"),
    // 信息更新失败
    RECORD_UPDATE_FAIL(-125, "信息更新失败", "Pembaharuan informasi gagal", "Cập nhật thông tin không thành công",
            "Informaiton updating failed"),
    // 信息保存失败
    RECORD_SAVE_FAIL(-126, "信息保存失败", "Penyimpanan informasi gagal", "Không thể lưu thông tin",
            "Information saving failed"),
    // 信息不存在
    RECORD_NOT_EXIST(-127, "信息不存在", "Informasi tidak ada", "Thông tin không tồn tại", "Information doesn't exist"),
    // 信息已经存在
    RECORD_EXISTS(-128, "信息已经存在", "Informasi telah ada", "Thông tin đã tồn tại", "Information existed already"),
    // 信息查询失败
    RECORD_SEARCH_FAIL(-129, "信息查询失败", "Pencarian informasi gagal", "Truy vấn thông tin không thành công",
            "Information searching failed"),
    // 获取融云token出错
    RONG_TOKEN_GET_ERROR(-130, "", "", "", ""),
    // 刷新融云token出错
    RONG_TOKEN_REFRESH_ERROR(-131, "", "", "", ""),

    // 参数错误
    AMOUNT_OUT_OF_RANGE(-132, "产品数据金额超出范围", "Parameter salah", "Lỗi tham số", "Wrong parameter"),
    // 非法请求
    ILLEGAL_REQUEST(-140, "非法请求", "Permintaan ilegal", "Yêu cầu bất hợp pháp", "Unvalid request"),

    REPEAT_OPERATE(-141, "重复操作", "Ulangi operasi", "Lặp lại thao tác", "Repeat operation"),

    // 未认证
    NOT_AUTH(-142, "请完成认证后再尝试", "Silakan lengkapi otentikasi dan coba lagi",
            "Vui lòng hoàn thành giấy chứng nhận trước khi thử lại", "Please finish the regidtration firstly"),

    USER_AUTH_NOT_ALL(-142, "用户未完成全部认证", "Pengguna belum menyelesaikan semua sertifikasi",
            "Người dùng chưa hoàn thành tất cả các chứng chỉ", "User has not completed all certifications"),

    // 超过广告上线限制
    EXCEEDING_THE_LIMIT(-143, "超过上限设置", "超过上限设置", "", ""),

    // 产品未上线
    PRODUCTS_NOT_ONLINE(-144, "未上线的产品", "未上线的产品", "", ""),
    // 热推产品已上线
    PRODUCTS_HOT_IS_ONLINE(-146, "该产品已热推", "该产品已热推", "", ""),
    // 参数错误
    PARAMETER_TOO_LONG(-145, "参数超长", "Parameter terlalu panjang", "Lỗi tham số", "Wrong parameter"),

    // 发送http请求发生异常
    HTTP_EXCEPTION(-404, "", "", "", ""),

    // 消息体
    // 验证码为空
    AUTH_ISNULL(-200, "验证码为空", "Kode verifikasi kosong", "Mã xác minh trống", "Blank verification code"),
    // 验证码失效，请重新获取
    AUTH_INVALID(-201, "验证码失效，请重新获取", "Kode verifikasi tidak valid, silahkan ambil kembali",
            "Mã xác minh không hợp lệ, vui lòng lấy lại", "Unvalid verification code, please request again"),
    // 验证码错误
    AUTH_ERROR(-202, "验证码错误", "Kode verifikasi salah", "Lỗi mã xác minh", "Wrong verification code"),
    // 验证码输错次数过多
    AUTH_FAIL_COUNT(-203, "验证码输错次数过多", "Input kode verifikasi salah banyak kali", "xác minh quá nhiều lần lỗi",
            "  Too many errors"),
    // 10分钟内只能发送3条短信
    AUTH_COUNT_TEN_LIMIT(-204, "10分钟内只能发送3条短信", "Hanya dapat kirim 3 pesan dalam waktu 10 menit",
            "Chỉ có thể gửi 3 tin nhắn  trong vòng 5 phút", "You can have only 3 SMS in 5 minutes"),
    // 24小时内只能发送10条同类短信
    AUTH_COUNT_24_HOUR(-205, "", "", "", ""),
    // 短信发送失败
    SMS_ERROR(-206, "短信发送失败", "Pengiriman pesan pendek gagal", "SMS không gửi được", "SMS sending failed"),
    // 密码为空
    PASSWORD_ISNULL(-220, "密码为空", "Kata sandi kosong", "Mật khẩu trống", "Blank password"),
    // 密码长度不合法
    PASSWORD_LENGTH(-221, "密码长度不合法", "Panjang pesan pendek ilegal", "Độ dài mật khẩu là bất hợp pháp",
            "Password in unvalid length"),
    // 密码格式错误
    PASSWORD_FORMAT_ERROR(-222, "密码格式错误", "Format kata sandi salah", "Định dạng mật khẩu sai",
            "Password in wrong form"),
    // 密码错误
    PASSWORD_ERROR(-223, "密码错误", "Kata sandi salah", "Mật khẩu sai", "Wrong password"),
    // 新密码为空
    NEW_PASSWORD_ISNULL(-224, "新密码为空", "Kata sandi baru kosong", "Mật khẩu mới trống", "Blank new password"),
    // 密码和验证码不能同时为空
    PASSWORD_AND_AUTH_ISNULL(-225, "密码和验证码不能同时为空", "Kata sandi dan kode verifikasi tidak boleh kosong secara bersamaan",
            "Không thể để trống mật khẩu và mã xác minh cùng một lúc",
            "Password and verificatoin code can not be blank at the same time"),
    // 原密码错误
    OLD_PASSWORD_ERROR(-226, "原密码错误", "Kata sandi sebelumnya salah", "Lỗi mật khẩu ban đầu", "Wrong old password"),
    // 密码不一致
    CONFIRM_PASSWORD_ERROR(-227, "密码不一致", "Kata sandi tidak sesuai", "Mật khẩu không nhất quán",
            "Inconsistant password"),
    // 密码过于简单
    PASSWORD_SIMPLE(-228, "密码过于简单", "", "Mật khẩu quá đơn giản", "The password is too simple"),
    // 用户手机号为空
    USER_PHONE_ISNULL(-240, "用户手机号为空", "Nomor ponsel pengguna kosong", "Số điện thoại di động của người dùng trống",
            "Blank user's phone number"),
    // 用户id 或手机号码为空
    UID_OR_PHONE_ISNULL(-241, "用户id 或手机号码为空", "ID Pengguna atau nomor ponsel kosong",
            "Id người dùng hoặc số điện thoại trống", "Blank user's ID or phone number"),
    // 手机号已存在
    PHONE_EXISTS(-242, "手机号已存在", "Nomor ponsel telah ada", "Số điện thoại đã tồn tại",
            "The phone number existed already"),
    // 无效的手机号
    PHONE_WRONG(-243, "无效的手机号", "Nomor ponsel yang tidak valid", "Số điện thoại không hợp lệ", "Unvalid phone number"),
    // 手机终端类型为空
    TERM_TYPE_ISNULL(-244, "手机终端类型为空", "Jenis akhir ponsel kosong", "Loại thiết bị đầu cuối điện thoại trống",
            "Blank phone terminal type"),
    // 标题为空
    TITLE_ISNULL(-260, "", "", "", ""),
    // 内容为空
    CONTENT_ISNULL(-261, "", "", "", ""),
    // 用户头像不能为空
    USER_AVATAR_ISNULL(-271, "用户头像不能为空", "Profil gambar pengguna tidak boleh kosong",
            "Hình đại diện người dùng không được để trống", "the user's profile pitcure can not be blank"),
    // 用户名或密码错误
    USER_NAME_PASSWORD_ERROR(-272, "用户名或密码错误", "Nama pelanggan atau kata sandi salah",
            "Tên người dùng hoặc mật khẩu không chính xác", "Wrong user's name or password"),
    // 用户名为空
    USER_NAME_ISNULL(-273, "用户名为空", "Nama pengguna kosong", "Tên người dùng trống", "Blank user's name"),
    // 排名排序不能为空
    ORDER_TYPE_RANK_ISNULL(-290, "排名排序不能为空", "Urutan ranking tidak boleh kosong", "Xếp hạng không được để trống",
            "Ranking can not be blank"),
    // 日期不能为空
    DATE_ISNULL(-291, "日期不能为空", "Tanggal tidak boleh kosong", "Ngày không được để trống", "Date can not be blank"),
    // 身份证不能为空
    ID_CARD_ISNULL(-300, "身份证不能为空", "Kartu identitas tidak boleh kosong", "ID không được để trống",
            "ID can not be blank"),
    // 身份证验证失败
    ID_CARD_VALIDATE_FAIL(-301, "身份证验证失败", "Verifikasi kartu identitas gagal", "Xác minh ID không thành công",
            "ID verification falied"),
    // 身份证号码重复
    ID_CARD_REPEAT(-302, "身份证号码重复", "Nomor identitas ulang kembali", "Số ID trùng lặp", "ID number repeat"),
    // 无效银行卡号
    BANK_CARD_VALIDATE_FAIL(-310, "无效银行卡号", "Nomor kartu bank tidak valid", "Số thẻ ngân hàng không hợp lệ",
            "Unvalid bank account"),
    // 无法上传文件
    FILE_DIR_CREATE_ERROR(-320, "无法上传文件", "Tidak dapat unggah dokumen", "Không thể tải file lên",
            "Not able to upload file"),
    // 文件上传发生异常
    FILE_UPLOAD_EXCEPTION(-321, "文件上传发生异常", "", "", ""),
    // 图片转换错误
    IMAGE_TRANS_ERROR(-322, "图片转换错误", "Pergantian gambar salah", "Lỗi chuyển đổi hình ảnh", "Pitcure conversion error"),
    // 图片类型不支持
    IMAGE_NOT_SUPPORT(-323, "图片类型不支持", "Jenis gambar tidak mendukung", "Loại hình ảnh không được hỗ trợ",
            "Unsupported picture type"),
    // 图片上传错误
    IMAGE_UPLOAD_ERROR(-324, "图片上传错误", "Unggahan gambar salah", "Lỗi tải lên hình ảnh", "Pitcure uploading error"),
    // 图片转换错误
    FOCUS_TYPE_ISNULL(-325, "图片转换错误", "Pergantian gambar salah", "Lỗi chuyển đổi hình ảnh", "Pitcure conversion error"),
    // 文件为空
    FILE_ISNULL(-326, "文件为空", "Dokumen kosong", "file trống", "Blank file"),
    // 读取数据流发生异常
    IO_EXCEPTION(-327, "读取数据流发生异常", "Pembacaan data stream terjadi masalah", "Đọc luồng dữ liệu bất thường",
            "Data flow reading is abnormal"),
    // 生成合同文件失败
    CONTRACT_CREATE_ERROR(-328, "生成合同文件失败", "", "", ""),
    // 设备IMEI不能为空
    IMEI_TOKEN_ISNULL(-330, "备IMEI不能为空", "IMEI peralatan tidak boleh kosong", "thiết bị IMEI  không được rỗng",
            "Device IMEI can not be blank"),
    // 搜索条件不能为空
    SEARCH_VALUE_ISNULL(-340, "搜索条件不能为空", "Persyaratan pencarian tidak boleh kosong",
            "Không thể để trống tiêu chí tìm kiếm", "Search criteria can not be empty"),
    // 备注字数过多
    REMARK_LENGTH_ISTOOLONG(-341, "备注字数过多", "jumlah kata keterangan terlalu banyak", "vượt quá số ký tự cho phép",
            "Too many words"),

    // 菲律宾 支付 打款码不存在或已过期
    PHPAY_LENDING_CODE_NOT_EXISTS(-401, "支付码不存在或已过期", "", "", "Payment code does not exist or expires"),

    // 区域ID为空
    REGION_ID_ISNULL(-501, "区域ID为空", "ID area kosong", "ID khu vực trống", "Blank area ID"),
    // 父级区域ID为空
    REGION_PID_ISNULL(-502, "父级区域ID为空", "ID area induk kosong", "ID khu vực dành cho cha  trống",
            "Blank parent area ID"),
    // 订单不存在
    ORDER_NOT_EXISTS(-601, "订单不存在", "Pesanan tidak ada", "Đơn đặt hàng không tồn tại", "Order doesn't exist"),
    // 订单校验失败，非法请求
    ORDER_CHECK_FAIL(-602, "订单校验失败，非法请求", "Verifikasi pesanan gagal, permintaan ilegal",
            "Xác minh đơn đặt hàng không thành công, yêu cầu bất hợp pháp",
            "Order verification failed, illegal request"),
    // 订单已失效
    ORDER_ALLREADY_INVALID(-603, "订单已失效", "Pesanan telah tidak valid", "Đơn đặt hàng đã hết hạn", "Order unvalid"),

    // 当前订单有资料退回，不允许审核通过
    ORDER_NEED_REUPLOAD(-604, "当前订单有资料退回，不允许审核通过",
            "Pesanan saat ini memiliki data yang dikembalikan, tidak diizinkan untuk melewati peninjauan",
            "Đơn đặt hiện tại có dữ liệu trả lại, không được phép chuyển",
            "The current order has data returned, not allowed to pass the review"),

    // 此订单未逾期，无法发放逾期优惠卷
    ORDER_OVERDUE_COUPON(-691, "订单未逾期，无法发放逾期优惠卷", "Pesanan tidak ada", "Đơn đặt hàng không tồn tại",
            "Order doesn't exist"),

    // 优惠结束时间已过期
    ORDER_OVERDUE_TIME_OUT(-695, "设置时间已过期", "Pengaturan waktu sudah kadaluarsa", "Thời gian thiết lập đã hết hạn",
            "the settled date expired"),

    // 当前订单状态不支持初审操作
    ORDER_FIRST_APPROVE_NOTSUPPORT(-609, "当前订单状态不支持初审操作",
            "Status pesanan saat ini tidak mendukung proses pemeriksaan awal",
            "Trạng thái đơn đặt hàng hiện tại không hỗ trợ đánh giá sơ bộ",
            "Current order status does not support preliminary checking"),
    // 当前订单状态不支持复审操作
    ORDER_SECOND_APPROVE_NOTSUPPORT(-610, "当前订单状态不支持复审操作",
            "Status pesanan saat ini tidak mendukung proses pemeriksaan ulang",
            "Trạng thái đơn đặt hàng hiện tại không hỗ trợ hoạt động đánh giá",
            "Current order status does not support checking review"),
    // 订单被驳回，请{0}天后再试
    ORDER_NOT_APPROVE_TIME(-611, "订单被驳回，请{0}天后再试", "Pesanan ditolak, mohon {0} hari kemudian coba lagi",
            "Đơn đặt hàng đã bị từ chối, vui lòng thử lại sau {0} ngày", "Order rejected, try again after {0} days"),
    // 您还有未还款订单，暂时无法下单
    ORDER_NOT_CARRY_OUT(-612, "您还有未还款订单，暂时无法下单",
            "Anda masih ada pesanan yang belum dikembalikan, saat ini tidak dapat melakukan pesanan",
            "Bạn vẫn chưa có đơn đặt hàng chưa thanh toán. Bạn không thể đặt hàng ngay bây giờ",
            "You have unpaid orders. You can't order right now"),
    // 放款单信息不存在
    ORDERLENDING_NOT_EXISTS(-630, "放款单信息不存在", "Informasi peminjaman dana pesanan tidak ada",
            "Thông tin đơn vay không tồn tại", "Lending information doesn't exist"),
    // 放款方式有误
    ORDERLENDING_LENDING_MODE_ERROR(-631, "放款方式有误", "", "", ""),
    // 当前订单状态不支持放款创建单异步请求
    ORDERLENDING_CAREATE_NOTIFY_NOTSUPPORT(-632, "当前订单状态不支持放款创建单异步请求",
            "Status pesanan ini tidak mendukung peminjaman dana untuk membuat pesanan permohonan tidak serempak",
            "Trạng thái đơn đặt hàng hiện tại không hỗ trợ cho vay để tạo các đơn yêu cầu không đồng bộ",
            "Current order status does not support lending to create asynchronous requests"),
    // 当前订单放款单创建异步请求已经处理，请勿重复发送
    ORDERLENDING_CAREATE_NOTIFY_ALLREADY(-633, "当前订单放款单创建异步请求已经处理，请勿重复发送",
            "Slip peminjaman dana ini telah diproses secara tidak serempak, mohon jangan kirim berulang-kali",
            "Yêu cầu không đồng bộ cho việc tạo câu lệnh đơn hàng hiện tại đã được xử lý. Không gửi lại.",
            "An asynchronous request for the creation of current order statement has been processed. Do not resend."),
    // 当前订单状态不支持放款异步操作
    ORDERLENDING_LENDING_NOTIFY_NOTSUPPORT(-635, "当前订单状态不支持放款异步操作",
            "Status pesanan saat ini tidak mendukung proses peminjaman dana tidak serempak",
            "Trạng thái đơn đặt hàng hiện tại không hỗ trợ hoạt động cho vay không đồng bộ",
            "Current order status does not support lending asynchronous operations"),
    // 订单放款异步请求已处理，请勿重复操作
    ORDERLENDING_LENDING_NOTIFY_ALLREADY(-636, "订单放款异步请求已处理，请勿重复操作",
            "Permintaan pesanan peminjaman dana tidak serempak sudah diproses, mohon jangan proses berulang-kali",
            "Yêu cầu đặt hàng không đồng bộ  đã được xử lý, không lặp lại",
            "Asynchronous request for order credit has been processed, do not repeat"),
    // 放款单校验失败，非法请求
    ORDERLENDING_CHECK_FAIL(-638, "放款单校验失败，非法请求", "Verifikasi slip peminjaman dana gagal, permintaan ilegal",
            "kiểm tra đặt hàng không thành công , yêu cầu bất hợp pháp", "Lending checking failed, illegal request"),
    // 查询三方放款单详情时发生异常
    ORDERLENDING_THIRD_QUERY_ERROR(-639, "查询三方放款单详情时发生异常",
            "Ketika pencarian rincian slip pencairan dana tiga pihak terjadi masalah",
            "ngoại lệ xảy ra khi truy vấn các chi tiết của lệnh chuyển tiền ba chiều",
            "Exception occurred during querying the details of the third-party lending order"),
    // 还款单信息不存在
    ORDERREDUND_NOT_EXISTS(-640, "还款单信息不存在", "Informasi slip pengembalian dana pesanan tidak ada",
            "Thông tin đơn trả nợ không tồn tại", "Repayment information doesn't exist"),
    // 当前订单状态不支持还款操作
    ORDERREDUND_NOTSUPPORT(-641, "当前订单状态不支持还款操作", "Status pesanan saat ini tidak mendukung proses pengembalian dana",
            "Trạng thái đơn đặt hàng hiện tại không hỗ trợ hoạt động trả nợ",
            "Current order status does not support repayment operations"),
    // 应还金额有误，请刷新重试
    ORDERREDUND_MONEY_ERROR(-642, "应还金额有误，请刷新重试",
            "Jumlah uang yang perlu dikembalikan salah, silahkan perbaharui dan coba kembali",
            "Số tiền  trả nợ không chính xác, vui lòng thử lại", "Wrong amount to repay, please refresh"),
    // 还款单状态不存在
    ORDERREDUND_STATUS_ILLEGAL(-643, "还款单状态不存在", "Status pengembalian dana tidak ada",
            "Trạng thái đơn trả nợ không tồn tại", "The repayment order doesn't exist"),
    // 还款单校验失败，非法请求
    ORDERREDUND_CHECK_FAIL(-644, "还款单校验失败，非法请求", "Verifikasi slip pengembalian dana gagal, permohonan ilegal",
            "Thông tin đơn trả nợ không thành công , yêu cầu bất hợp pháp",
            "Repayment checking verification failed, illegal request"),
    // 尚未到达还款时间，请关注您的最早还款时间
    ORDERREDUND_NOT_REACH_REFUND_TIME(-645, "尚未到达还款时间，请关注您的最早还款时间",
            "Belum jatuh tempol, mohon perhatikan SMS atau SMS APP anda.",
            "chưa đến thời gian hoàn trả,xin vui long  thanh toán theo thời gian đã cam kết .",
            "Not yet reached the repayment time"),
    // 当前还款单不支持创建异步请求
    ORDERREDUND_CAREATE_NOTIFY_NOTSUPPORT(-646, "当前还款单不支持创建异步请求",
            "Slip pengembalian dana saat ini tidak mendukung permintaan pembuatan tidak serempak",
            "đơn trả nợ hiện tại không hỗ trợ tạo yêu cầu không đồng bộ",
            "Current repayment order does not support creating asynchronous requests"),
    // 当前还款单创建异步请求已经处理，请勿重复发送
    ORDERREDUND_CAREATE_NOTIFY_ALLREADY(-647, "当前还款单创建异步请求已经处理，请勿重复发送",
            "Permintaan pembuatan tidak serempak slip pengembalian dana telah diproses, mohon tidak mengirim ulang kembali",
            "Yêu cầu tạo danh sách trả nợ không đồng bộ hiện tại đã được xử lý, không cần gửi lại",
            "Asynchronous creation request of the current repayment order has been processed, do not send it again"),
    // 当前还款单不支持还款异步请求
    ORDERREDUND_REFUND_NOTIFY_NOTSUPPORT(-648, "当前还款单不支持还款异步请求",
            "Slip pengembalian dana saat ini tidak mendukung permintaan pengembalian dana tidak serempak",
            "Danh sách trả nợ hiện tại không hỗ trợ yêu cầu trả tiền không đồng bộ",
            "Current repayment order does not support repayment asynchronous requests"),
    // 当前还款单还款异步请求已经处理，请勿重复发送
    ORDERREDUND_REFUND_NOTIFY_ALLREADY(-649, "当前还款单还款异步请求已经处理，请勿重复发送",
            "Permintaan pengembalian dana tidak serempak slip pengembalian dana saat ini telah diproses, mohon tidak mengirim ualng kembali",
            "Yêu cầu thanh toán không đồng bộ thanh toán hiện tại đã được xử lý, vui lòng không gửi lại yêu cầu",
            "The current payment repayment asynchronous request has been processed, please do not resend"),
    // 查询三方收款单详情时发生异常
    ORDERREDUND_REFUND_THIRD_QUERY_ERROR(-650, "查询三方收款单详情时发生异常",
            "Ketika pencarian rincian slip penerimaan dana tiga pihak terjadi masalah",
            "Đã xảy ra trường hợp ngoại lệ khi bạn truy vấn chi tiết về thanh ghi tiền mặt của bên thứ ba",
            "Exception occurred during checking the details of the third-party collection bill"),
    // 不支持的支付通道
    ORDERREDUND_CHANNEL_NOTSUPPORT(-651, "不支持的支付通道", "", "", ""),
    // 不支持的还款方式
    ORDERREDUND_PAYTYPE_NOTSUPPORT(-652, "不支持的还款方式", "", "", ""),
    // 不支持的还款银行
    ORDERREDUND_BANK_NOTSUPPORT(-653, "不支持的还款银行", "", "", ""),
    // 当前订单状态不支持人工确认还款操作
    ORDERREDUND_MANUAL_NOTSUPPORT(-655, "当前订单状态不支持人工确认还款操作",
            "Status pesanan saat ini tidak mendukung proses konfirmasi manual",
            "Trạng thái đơn đặt hàng hiện tại không hỗ trợ xác nhận thủ công các hoạt động trả nợ",
            "Current order status does not support manual confirmation of repayment operations"),
    // 人工确认还款时发生异常
    ORDERREDUND_MANUAL_ERROR(-656, "人工确认还款时发生异常", "Ketika konfirmasi manual pengembalian dana terjadi masalah",
            "Bất thường xảy ra khi xác nhận thanh toán thủ công",
            "Exception occurs during manually confirming repayment"),
    // 当前订单已还款
    ORDERREDUND_ALLREADY_REFUNED(-657, "当前订单已还款", "Pesanan saat ini telah dilunasi",
            "Đã thanh khoản,Vui lòng làm mới sau vài phút", "order end"),
    // 优惠金额不得小于还款金额
    ORDERREDUND_COUPONAMOUT_NOTLESS_REAMOUNT(-658, "优惠金额不得大于还款金额", "Nilai promo tidak boleh melebihi jumlah pembayaran",
            "Số tiền chiết khấu không được lớn hơn số tiền trả nợ",
            "deducted amount can't be more than the amount-to-repay"),
    // 该订单已有未过期的逾期优惠政策
    ORDER_NOT_OVERDAY(-690, "该订单已有未过期的逾期优惠政策", "Pinjaman ini memiliki kebijakan promo jatuh tempo yang masih berlaku",
            "Khoản vay  có  phiếu ưu đãi quá hạn chưa hết hạn", "this loan is in valid preferencial term"),
    // 部分还款金额低于最小限制
    ORDER_PARTIAL_REPAYMENT_AMOUNT_EXCEED_LIMIT(-696, "部分还款金额低于最小限制", "Nilai pembayaran sebagian dibawah batas minimum",
            "Số tiền hoàn trả một phần thấp hơn giới hạn tối thiểu",
            "this partly repayment amount is less that the bottomline"),
    // 逾期优惠金额超过限制
    ORDER_OVERDUE_AMOUNT_EXCEED_LIMIT(-699, "逾期优惠金额超过限制", "Nilai promo jatuh tempo melebihi batas",
            "Số tiền ưu đãi quá hạn vượt quá giới hạn", "deducted amount is above the ceiling amount"),
    // 优惠项超过系统限制
    OFFER_EXCEEDS_SYSTEM_LIMIT(-670, "优惠项超过系统限制", "Penawaran sudah melampai batas yang terdapat pada sistem",
            "Sử  ưu đãi  vượt quá giới hạn hệ thống", "this preferencial term is above the system limition"),
    // 逾期优惠申请已被处理
    OVERCOUP_APPLICATION_PROCESSED(-693, "该逾期优惠政策申请已处理", "Permintaan kebijakan promo jatuh tempo sedang diproses",
            "Chương trình ưu đãi quá hạn đã được xử lý",
            "this overdue-preferencial-term application has been processed "),
    // 角色名已经存在
    ROLENAME_EXISTS(-701, "角色名已经存在", "Nama peran telah ada", "Tên vai trò đã tồn tại", "The role name existed already"),
    // 存在与此角色关联的管理员
    ROLE_HAVE_ADMINS(-702, "存在与此角色关联的管理员", "Ada administrator yang terkait dengan peran ini",
            "Có quản trị viên được liên kết với vai trò này", "There is an administrator associated with this role"),
    // 角色不存在
    ROLE_NOTEXISTS(-703, "角色不存在", "Peran tidak ada", "Vai trò không tồn tại", "This role does not exist"),
    // 催收订单已被转派
    COLLECTION_ORDER_NOT_SELF_OPERATE(-801, "催收订单已被转派", "", "", ""),

    // 催收订单已被转派
    SERVICE_ORDER_NOT_SELF_OPERATE(-802, "客服提醒订单信息错误", "", "", ""),
    // 获取微信openid异常
    WX_OPENID_ERROR(-1001, "获取微信openid异常", "", "", ""),
    // 获取微信用户信息异常
    WX_USERINFO_ERROR(-1002, "获取微信用户信息异常", "", "", ""),
    // 微信openid为空
    WX_OPENID_ISNULl(-1003, "微信openid为空", "", "", ""),
    // 加载微信证书发生异常
    WX_CERT_EXCEPYION(-1004, "加载微信证书发生异常", "", "", ""),
    // 微信退款发生异常
    WX_REFUND_EXCEPYION(-1005, "微信退款发生异常", "", "", ""),
    // 支付宝退款发生异常
    ZFB_REFUND_EXCEPYION(-1006, "支付宝退款发生异常", "", "", ""),
    // 订单金额错误
    NOTIFY_MONEY_ERROR(-1007, "订单金额错误", "Jumlah uang pesanan salah", "Số lượng đơn đặt hàng không chính xác",
            "Wrong order amount"),
    // 通知已经处理，无需再次处理
    NOTIFY_ALLREADY_DEALED(-1008, "通知已经处理，无需再次处理", "Pemberitahuan telah diproses, tidak perlu memproses lagi",
            "Thông báo đã được xử lý và không cần xử lý lại",
            "Notifications have been processed and no need to process again"),
    // 创建二维码图片失败
    QRCODE_CREATE_ERROR(-1011, "创建二维码图片失败", "", "", ""),
    // 识别二维码图片失败
    QRCODE_DECODE_ERROR(-1012, "识别二维码图片失败", "", "", ""),
    // 请填写完活动内容
    PELEASE_FILL_CONTENT(-1021, "请填写完活动内容", "", "", ""),
    // 没有权限操作
    NOT_PERMISSION(-1031, "没有权限操作", "Tidak ada ijin operasi", "Không có cấp quyền hoạt động ",
            "No permission operation"),
    // 该用户不能登录
    USER_NOT_LOGIN(-1032, "该用户不能登录", "Pengguna ini tidak dapat masuk", "Người dùng không thể đăng nhập",
            "The user cannot log in"),
    // 用户已锁定
    USER_DISABLED(-1033, "用户已锁定", "Pengguna telah terkunci", "người dùng đã bị  khóa ", "User locked"),
    // 用户已在该俱乐部
    USER_EXIT_CLUB(-1040, "用户已在该俱乐部", "", "", ""),
    // 该用户没有加入俱乐部
    USER_NOT_CLUB(-1041, "该用户没有加入俱乐部", "", "", ""),
    // 该用户已绑定过银行卡
    SELLER_BINDING_BANK(-1070, "该用户已绑定过银行卡", "Kartu bank pengguna ini telah pernah terikat",
            "Người dùng đã ràng buộc thẻ ngân hàng", "The user has bound a bank account already"),
    // 请绑定本人银行卡
    PLEASE_BINDING_YOUSELF_BANK(-1071, "请绑定本人银行卡", "Mohon ikatkan kartu bank saya",
            "Vui lòng liên kết thẻ ngân hàng của bạn thân", "Please bind your own bank account"),
    // 两次卡号不一致
    CONFIRM_BANK_NO_ERROR(-1072, "两次卡号不一致", "Dua kali nomor kartu tidak sesuai", "Số thẻ hai lần không nhất quán",
            "Inconsistant bank account"),
    // 请输入登录用户名
    ADMIN_LOGIN_NAME_IS_NULL(-2000, "请输入登录用户名", "Silahkan masukkan nama pengguna login",
            "Vui lòng nhập tên người dùng đăng nhập", "Please enter the user's name"),

    //
    BANNER_REPEATING_TIME(-2100, "广告时间段有重复", "Waktu iklan tumpang tindih", "Vui lòng nhập tên người dùng đăng nhập",
            "advertisement period overlaps"),
    // 定时提醒任务失败
    JOB_WARN_ERROR(-3000, "定时提醒任务失败", "", "", ""),
    // 定时短信任务失败
    JOB_SMS_ERROR(-3000, "定时短信任务失败", "", "", ""),
    // 定时计费任务失败
    JOB_FEE_ERROR(-3000, "定时计费任务失败", "", "", ""),

    // 未达到提现金额
    NOT_CASH_RAISED(-4000, "提现金额不少于50000 ", "Jumlah minimal tarik tunai adalah Rp{0}",
            "Số tiền được huy động không nhỏ hơn {0} VND", "The encashment amount can not be less than PHP {0}."),

    // 提现失败
    NOT_GET_CASH(-4001, "提现失败", "Penarikan Tunai Gagal", "Lỗi rút tiền mặt", "encashment failed"),

    // 订单不存在
    WITHDRAW_NOT_EXISTS(-4002, "提现记录不存在", "Tidak ada riwayat tarik tunai", "Hồ sơ rút tiền không tồn tại",
            "encashment record doesn't exist"),

    // 您还有未还款订单，暂时无法提现
    ORDER_NOT_REPAYMENT(-4003, "您有未完结订单，无法提现", "Order anda belum selesai, Tidak bisa Melakukan penarikan",
            "Bạn có một lệnh chưa thanh toán và không thể rút tiền mặt",
            "You have unfinished loan repayment.  Encashment not available."),

    // 您还有一笔提现未完成，暂时无法再次提现
    WITHDRAW_NOT_OVER(-4004, "当前提现未完成", "Tarik tunai belum selesai", "Khi tiền đề chưa hoàn thành",
            "encashment unfinished"),

    // 请先处理未跟踪订单
    PROCESS_UNTRACKED_ORDER_FIRST(-4005, "请先处理未跟踪订单", "Harap proses pesanan yang tidak terlacak terlebih dahulu",
            "Vui lòng xử lý các đơn đặt hàng chưa được xử lý trước", "Please process untracked orders first"),

    // 当前已无可认领订单
    NO_CLAIMABLE_ORDERS(-4006, "当前已无可认领订单", "Saat ini tidak ada pesanan yang dapat diklaim",
            "Hiện tại không có đơn đặt hàng nào có thể khiếu nại", "There are currently no claimable orders"),
    /*
     * 贷超错误信息
     *
     */
    PHONE_ALREADY_BINDED(-3, "手机号已被绑定", "Nomor telepon telah diikat", "Số điện thoại đã bị ràng buộc",
            "The phone number has been bound"),

    // 设备类型为空
    FACEBOOKID_ISNULL(-4, "Facebook ID为空", "ID Facebook kosong", "ID Facebook trống", "Blank Facebook ID"),

    PRODUCT_EXIST(-12, "产品已存在", "Produk sudah ada", "Sản phẩm đã tồn tại", "Product already exists"),

    PRODUCT_DATA_NULL(-5, "产品数据不能为空", "Data produk tidak boleh kosong", "Dữ liệu sản phẩm không được để trống",
            "Product data cannot be empty"),

    PRODUCT_QUESTION_NULL(-6, "产品常见问题不能为空",
            "10/5000\r\n" + "Chǎnpǐn chángjiàn wèntí bùnéng wéi kōng\r\n" + "FAQ Produk tidak boleh kosong",
            "Câu hỏi thường gặp về sản phẩm không được để trống", "Product FAQs cannot be empty"),

    PRODUCT_NOT_EXIST(-7, "产品不存在", "Produk tidak ada", "Sản phẩm không tồn tại", "Product does not exist"),

    PRODUCT_AMOUNT_NOT_EXIST(-8, "产品借款数据不存在", "Data pinjaman produk tidak ada",
            "Dữ liệu cho vay sản phẩm không tồn tại", "Product loan data does not exist"),

    PRODUCT_QUESTION_NOT_EXIST(-9, "产品常见问题不存在", "FAQ Produk tidak ada", "Câu hỏi thường gặp về sản phẩm không tồn tại",
            "Product FAQ does not exist"),

    PRODUCT_FIXED_POSITION_EXIST(-11, "该固定位置已被使用，请更换固定位置", "Posisi tetap telah digunakan, silakan ganti posisi tetap",
            "Vị trí cố định đã được sử dụng, hãy thay thế vị trí cố định",
            "The fixed position has been used, please replace the fixed position"),
    ACCOUNT_KIT_PARAM_MISSING(-12, "缺少Account Kit参数", "Parameter Kit Akun Tidak Ada", "Thiếu thông số Bộ tài khoản",
            "Missing Account Kit parameters"),
    ACCOUNT_KIT_ID_NOTMATCH(-13, "Account Kit ID不匹配", "ID Akun Kit tidak cocok", "ID bộ tài khoản không khớp",
            "Account Kit ID not match"),
    ACCOUNT_KIT_PHONE_NOTMATCH(-15, "电话和Account Kit信息不匹配", "Informasi Telepon dan Akun Kit tidak cocok",
            "Thông tin về Bộ công cụ và Điện thoại không khớp",
            "Phone and Account Kit information does not match"),
    ACCOUNT_KIT_INVOKE_FAIL(-14, "Account Kit 调用失败", "Panggilan Akun Kit gagal", "Cuộc gọi Kit tài khoản không thành " +
            "công", "Account Kit invoke fail"),
    PRODUCT_NOT_ONLINE_YET(-16, "您申请的产品目前暂未上架，请刷新后再试", "Produk yang Anda ajukan saat ini tidak tersedia. Segarkan dan" +
            " coba lagi.", "Sản phẩm bạn đã áp dụng hiện không khả dụng. Vui lòng làm mới và thử lại.", "The product " +
            "you applied for is currently not available. Please refresh and try again."),
    UNSUPPORTED_OPERATION(-17, "不支持的操作方式", "", "", ""),
    PRODUCT_ONLINE(-18, "产品在线，请下线产品后再删除", "", "", ""),
    ;

    /**
     * 返回码MAP
     */
    private static final Map<Integer, ResultCode> map;

    static {
        map = new HashMap<>();
        for (ResultCode as : values()) {
            map.put(as.code, as);
        }
    }

    // 成员变量
    private int code; // 编码
    private String CNContent;// 中文版本
    private String IDContent;// 印尼内容
    private String VNContent;// 越南内容
    private String PHContent;// 菲率宾内容

    private ResultCode(int code, String CNContent, String IDContent, String VNContent, String PHContent) {
        this.code = code;
        this.CNContent = CNContent;
        this.IDContent = IDContent;
        this.VNContent = VNContent;
        this.PHContent = PHContent;
    }

    public static ResultCode getType(int code) {
        if (code <= 0) {
            return null;
        }
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.code == code) {
                return resultCode;
            }
        }
        return null;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static ResultCode fetch(int code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchCNContent(int code) {
        ResultCode as = map.get(code);
        return as != null ? as.CNContent : null;
    }

    /**
     * 根据编码获取显示名
     *
     * @param code
     * @return
     */
    public static String fetchIDContent(int code) {
        ResultCode as = map.get(code);
        return as != null ? as.IDContent : null;
    }

    public static String fetchVNContent(int code) {
        ResultCode as = map.get(code);
        return as != null ? as.VNContent : null;
    }

    public static String fetchPHContent(int code) {
        ResultCode as = map.get(code);
        return as != null ? as.PHContent : null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCNContent() {
        return CNContent;
    }

    public void setCNContent(String CNContent) {
        this.CNContent = CNContent;
    }

    public String getIDContent() {
        return IDContent;
    }

    public void setIDContent(String IDContent) {
        this.IDContent = IDContent;
    }

    public String getVNContent() {
        return VNContent;
    }

    public void setVNContent(String VNContent) {
        this.VNContent = VNContent;
    }

    public String getPHContent() {
        return PHContent;
    }

    public void setPHContent(String PHContent) {
        this.PHContent = PHContent;
    }

    /**
     * 国际语言返回
     *
     * @return
     * @Description
     * @author <a href="jiangxin8116@adpanshi.com">jiangxin</a>
     */
    public String getI18NContent() {

        if (Constant.COUNTRY.equals(CountryType.INDONESIA.getCode())) {
            return IDContent;
        } else if (Constant.COUNTRY.equals(CountryType.VIETNAM.getCode())) {
            return VNContent;
        } else if (Constant.COUNTRY.equals(CountryType.PHILIPPINES.getCode())) {
            return PHContent;
        }
        return CNContent;
    }

}
