package com.example.apporio.placeholderdemo;

import java.util.List;

public class    ModelMyData {


    private List<PlaceholderBean> placeholder;

    public List<PlaceholderBean> getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(List<PlaceholderBean> placeholder) {
        this.placeholder = placeholder;
    }

    public static class PlaceholderBean {
        private List<HolderDataBean> holder_data;

        public List<HolderDataBean> getHolder_data() {
            return holder_data;
        }

        public void setHolder_data(List<HolderDataBean> holder_data) {
            this.holder_data = holder_data;
        }

        public static class HolderDataBean {
            /**
             * url : https://images.pexels.com/photos/19090/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350
             * name : shooes1
             */

            private String url;
            private String name;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
