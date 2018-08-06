package com.example.apporio.flipcart;

import java.util.List;

public class ModelData {


    private List<FlipcartBean> flipcart;

    public List<FlipcartBean> getFlipcart() {
        return flipcart;
    }

    public void setFlipcart(List<FlipcartBean> flipcart) {
        this.flipcart = flipcart;
    }

    public static class FlipcartBean {
        private List<ImagesBean> images;

        public List<ImagesBean> getImages() {
            return images;
        }

        public void setImages(List<ImagesBean> images) {
            this.images = images;
        }

        public static class ImagesBean {
            /**
             * url : https://image.freepik.com/free-vector/special-offer-background_1126-221.jpg
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
