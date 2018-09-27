package com.marke.constant;

/**
 * 数据库字段相关信息常量类
 *
 * @author marke.huang
 * @date 2018/9/27 0027 下午 3:46
 */
public final class FieldContants {

    private FieldContants() {
    }

    /**
     * 公共字段
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:46
     */
    public final class PublicField {

        /**
         * 流水号
         */
        public final static String REFCODE = "refcode";

        /**
         * 创建日期
         */
        public final static String CREATEDATE = "createDate";

        /**
         * 创建用户
         */
        public final static String CREATEUSER = "createUser";

        /**
         * 最后修改日期
         */
        public final static String LASTMODDATE = "lastModDate";

        /**
         * 最后修改日期
         */
        public final static String LASTMODUSER = "lastModUser";

        /**
         * 操作类型
         */
        public final static String EDTID = "edtid";

        /**
         * 数据状态
         */
        public static final String DATA_STATUS = "dataStatus";
    }

    /**
     * 公共字段值
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:46
     */
    public final class PublicFieldValue {

        private PublicFieldValue() {
        }

        /**
         * 数据删除标记：否=0(Default)
         */
        public static final String DEL_FLAG_NO = "0";

        /**
         * 数据删除标记：是
         */
        public static final String DEL_FLAG_YES = "1";

        /**
         * 数据启用[1=启用]
         */
        public static final String USE_FLAG_YES = "1";

        /**
         * 数据禁用[0=禁用]
         */
        public static final String USR_FLAG_NO = "0";

        /**
         * EDTID - NEW
         */
        public static final String EDTID_NEW = "NEW";

        /**
         * EDTID - MOD
         */
        public static final String EDTID_MOD = "MOD";

        /**
         * EDTID - DEL
         */
        public static final String EDTID_DEL = "DEL";

        /**
         * 资料状态-保存
         */
        public static final String DATA_STATUS_SAVE = "01";

        /**
         * 资料状态-流程中
         */
        public static final String DATA_STATUS_PROCESS = "11";

        /**
         * 资料状态-拒绝
         */
        public static final String DATA_STATUS_REFUSE = "12";

        /**
         * 资料状态-生效
         */
        public static final String DATA_STATUS_EFFECTIVE = "99";

        /**
         * 所属系统类型[1=后台](运营/管理)
         */
        public static final String SYSTEM_TYPE_MANAGE = "1";

        /**
         * 所属系统类型[2=前台](门户)
         */
        public static final String SYSTEM_TYPE_PORTAL = "2";

        /**
         * 是否存在[1= 是]
         */
        public static final String EXISTENCE_YES = "1";

        /**
         * 是否存在[0=否]
         */
        public static final String EXISTENCE_NO = "0";
    }

}
