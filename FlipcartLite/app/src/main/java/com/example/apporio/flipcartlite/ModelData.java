package com.example.apporio.flipcartlite;

import java.util.List;

public class ModelData {

    private List<MainBean> main;

    public List<MainBean> getMain() {
        return main;
    }

    public void setMain(List<MainBean> main) {
        this.main = main;
    }

    public static class MainBean {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * url : http://versedtech.org/wp-content/uploads/2015/05/Ixigo-ties-up-with-Citrus-Pay.jpg
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
