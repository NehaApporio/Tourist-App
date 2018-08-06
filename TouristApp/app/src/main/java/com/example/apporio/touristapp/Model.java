package com.example.apporio.touristapp;

import java.util.List;

public class Model {


    /**
     * result : 1
     * response : [{"image":"https://www.tourmyindia.com/blog/wp-content/uploads/2015/11/india-gate.jpg","name":"IndiaGate","place":"Delhi","rating":4.5},{"image":"https://d30fl32nd2baj9.cloudfront.net/media/2017/10/03/taj-mahal.jpg/ALTERNATES/w640/Taj-Mahal.jpg","name":"TajMahal","place":"Agra","rating":5},{"image":"https://indianmonumentattractions.files.wordpress.com/2013/01/indian-monument-attractions-3-hawa-mahal.jpg","name":"Hawa Mahal","place":"Jaipur","rating":4},{"image":"https://www.tourmyindia.com/blog/wp-content/uploads/2015/11/qutub-minar.jpg","name":"Qutub Minar","place":"New Delhi","rating":4.5},{"image":"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/GolGumbaz2.jpg/1024px-GolGumbaz2.jpg","name":"Gol Gumbuz","place":"Karnataka","rating":4.5},{"image":"https://content1.jdmagicbox.com/comp/hyderabad/88/040p2600288/catalogue/charminar-fort-charminar-hyderabad-tourist-attraction-p9if.jpg","name":"CharMinar","place":"Hyderabad","rating":4.8}]
     */

    private int result;
    private List<ResponseBean> response;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * image : https://www.tourmyindia.com/blog/wp-content/uploads/2015/11/india-gate.jpg
         * name : IndiaGate
         * place : Delhi
         * rating : 4.5
         */

        private String image;
        private String name;
        private String place;
        private double rating;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }
}
