package com.example.apporio.flipcarddesign;

import java.util.List;

public class FlipCart {


    private List<FlipcartviewBean> flipcartview;

    public List<FlipcartviewBean> getFlipcartview() {
        return flipcartview;
    }

    public void setFlipcartview(List<FlipcartviewBean> flipcartview) {
        this.flipcartview = flipcartview;
    }

    public static class FlipcartviewBean {
        private List<TinderBean> tinder;

        public List<TinderBean> getTinder() {
            return tinder;
        }

        public void setTinder(List<TinderBean> tinder) {
            this.tinder = tinder;
        }

        public static class TinderBean {
            /**
             * url : https://images.pexels.com/photos/112460/pexels-photo-112460.jpeg?cs=srgb&dl=car-vehicle-luxury-112460.jpg&fm=jpg
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
