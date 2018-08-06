package com.example.apporio.placepickergson;

import java.util.List;

public class ModelData {

    /**
     * predictions : [{"description":"1600 Amphitheatre Parkway, Mountain View, CA, USA","id":"3efbe9263dab948f396f323188f7b0b28d821848","matched_substrings":[{"length":4,"offset":0},{"length":12,"offset":5}],"place_id":"ChIJ2eUgeAK6j4ARbn5u_wAGqWA","reference":"ClRJAAAARefKWs101ERYS30slnGmgCXglzZ9NwTZQeMUN6BTKLu8lxTDmRvrKBMePQwq_8awwUahVQgdcc6KXiOFLHNNBLYlEeoWd0d46VUcLX8Z2C4SEK34M7HEC8LlbIdFTC7DNLMaFKcCjtaVHcuYsJzBBkC99BvgNPU-","structured_formatting":{"main_text":"1600 Amphitheatre Parkway","main_text_matched_substrings":[{"length":4,"offset":0},{"length":12,"offset":5}],"secondary_text":"Mountain View, CA, USA"},"terms":[{"offset":0,"value":"1600"},{"offset":5,"value":"Amphitheatre Parkway"},{"offset":27,"value":"Mountain View"},{"offset":42,"value":"CA"},{"offset":46,"value":"USA"}],"types":["street_address","geocode"]},{"description":"1600 Amphitheatre Drive, Wilmington, NC, USA","id":"6f435e2bd24c6e2baf8b0e51acc427dfa16aed64","matched_substrings":[{"length":17,"offset":0}],"place_id":"EiwxNjAwIEFtcGhpdGhlYXRyZSBEcml2ZSwgV2lsbWluZ3RvbiwgTkMsIFVTQQ","reference":"CjQwAAAAWwkdF5FD-VwjY2gdZ-P_XsMM6C2yzztFwNdbH_Wzos8sNYL41LDMqIkSGkzl4F6gEhCY9Vm5AAkhsmVctYnLXxyaGhRLBM6f7uo1WNU4h58JTstB9Vwhpw","structured_formatting":{"main_text":"1600 Amphitheatre Drive","main_text_matched_substrings":[{"length":17,"offset":0}],"secondary_text":"Wilmington, NC, USA"},"terms":[{"offset":0,"value":"1600 Amphitheatre Drive"},{"offset":25,"value":"Wilmington"},{"offset":37,"value":"NC"},{"offset":41,"value":"USA"}],"types":["route","geocode"]},{"description":"1600 Amphitheatre - Sharjah - United Arab Emirates","id":"6c758d346ed816d3ee74d96571ec7b8898d6bfad","matched_substrings":[{"length":17,"offset":0}],"place_id":"EjIxNjAwIEFtcGhpdGhlYXRyZSAtIFNoYXJqYWggLSBVbml0ZWQgQXJhYiBFbWlyYXRlcw","reference":"CkQ2AAAAPmz9uvjj3Cu4rIKIXOll1o7jkUybFW9YfB8qjNcwJiwerUcZq-N1VQW4NYrUlyaEUbblm8YhUJZH0fUns1DjlhIQYMFS9FDhYHWgHpdDfXJFkhoUtppzK4uz0d60H7rfoNQVnxIFHvo","structured_formatting":{"main_text":"1600 Amphitheatre","main_text_matched_substrings":[{"length":17,"offset":0}],"secondary_text":"Sharjah - United Arab Emirates"},"terms":[{"offset":0,"value":"1600 Amphitheatre"},{"offset":20,"value":"Sharjah"},{"offset":30,"value":"United Arab Emirates"}],"types":["route","geocode"]},{"description":"1600 Amphitheatre Road, Mount Lonarch VIC, Australia","id":"92dd83def89b61b5dced0a4f446493a41f7a1a9c","matched_substrings":[{"length":17,"offset":0}],"place_id":"EjQxNjAwIEFtcGhpdGhlYXRyZSBSb2FkLCBNb3VudCBMb25hcmNoIFZJQywgQXVzdHJhbGlh","reference":"CkQ4AAAAlT4pzCzI6dWtxlfPZhaCC29AIU3Exxb6ntYg38wSngnnDUf4coWC-JIzw2N5vFBXaf_lKvJL4HA70kylxtLNrBIQD_gQ_EmOj4AaTd1xuGHOOxoUWZY6g9vLPdb0atfNxQ0izvW5tw0","structured_formatting":{"main_text":"1600 Amphitheatre Road","main_text_matched_substrings":[{"length":17,"offset":0}],"secondary_text":"Mount Lonarch VIC, Australia"},"terms":[{"offset":0,"value":"1600 Amphitheatre Road"},{"offset":24,"value":"Mount Lonarch"},{"offset":38,"value":"VIC"},{"offset":43,"value":"Australia"}],"types":["route","geocode"]},{"description":"1600 Amphitheatre Circuit, Baulkham Hills NSW, Australia","id":"db0ba8a60648ace71980e64b1b652f41ba31e4e0","matched_substrings":[{"length":17,"offset":0}],"place_id":"EjgxNjAwIEFtcGhpdGhlYXRyZSBDaXJjdWl0LCBCYXVsa2hhbSBIaWxscyBOU1csIEF1c3RyYWxpYQ","reference":"CkQ8AAAAQazyDXtnS3rcMLtghgz4xoI709kUaB6IdKAB4-dqRriDlvElTcZEw_yqyliI7uhnm3UBBoBda9e4ZONPz880cxIQm6qttoomsX49vWxN_0UtfhoURE3S6EImjx1Io-mlgqasns-Dqg4","structured_formatting":{"main_text":"1600 Amphitheatre Circuit","main_text_matched_substrings":[{"length":17,"offset":0}],"secondary_text":"Baulkham Hills NSW, Australia"},"terms":[{"offset":0,"value":"1600 Amphitheatre Circuit"},{"offset":27,"value":"Baulkham Hills"},{"offset":42,"value":"NSW"},{"offset":47,"value":"Australia"}],"types":["route","geocode"]}]
     * status : OK
     */

    private String status;
    private List<PredictionsBean> predictions;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PredictionsBean> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<PredictionsBean> predictions) {
        this.predictions = predictions;
    }

    public static class PredictionsBean {
        /**
         * description : 1600 Amphitheatre Parkway, Mountain View, CA, USA
         * id : 3efbe9263dab948f396f323188f7b0b28d821848
         * matched_substrings : [{"length":4,"offset":0},{"length":12,"offset":5}]
         * place_id : ChIJ2eUgeAK6j4ARbn5u_wAGqWA
         * reference : ClRJAAAARefKWs101ERYS30slnGmgCXglzZ9NwTZQeMUN6BTKLu8lxTDmRvrKBMePQwq_8awwUahVQgdcc6KXiOFLHNNBLYlEeoWd0d46VUcLX8Z2C4SEK34M7HEC8LlbIdFTC7DNLMaFKcCjtaVHcuYsJzBBkC99BvgNPU-
         * structured_formatting : {"main_text":"1600 Amphitheatre Parkway","main_text_matched_substrings":[{"length":4,"offset":0},{"length":12,"offset":5}],"secondary_text":"Mountain View, CA, USA"}
         * terms : [{"offset":0,"value":"1600"},{"offset":5,"value":"Amphitheatre Parkway"},{"offset":27,"value":"Mountain View"},{"offset":42,"value":"CA"},{"offset":46,"value":"USA"}]
         * types : ["street_address","geocode"]
         */

        private String description;
        private String id;
        private String place_id;
        private String reference;
        private StructuredFormattingBean structured_formatting;
        private List<MatchedSubstringsBean> matched_substrings;
        private List<TermsBean> terms;
        private List<String> types;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public StructuredFormattingBean getStructured_formatting() {
            return structured_formatting;
        }

        public void setStructured_formatting(StructuredFormattingBean structured_formatting) {
            this.structured_formatting = structured_formatting;
        }

        public List<MatchedSubstringsBean> getMatched_substrings() {
            return matched_substrings;
        }

        public void setMatched_substrings(List<MatchedSubstringsBean> matched_substrings) {
            this.matched_substrings = matched_substrings;
        }

        public List<TermsBean> getTerms() {
            return terms;
        }

        public void setTerms(List<TermsBean> terms) {
            this.terms = terms;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public static class StructuredFormattingBean {
            /**
             * main_text : 1600 Amphitheatre Parkway
             * main_text_matched_substrings : [{"length":4,"offset":0},{"length":12,"offset":5}]
             * secondary_text : Mountain View, CA, USA
             */

            private String main_text;
            private String secondary_text;
            private List<MainTextMatchedSubstringsBean> main_text_matched_substrings;

            public String getMain_text() {
                return main_text;
            }

            public void setMain_text(String main_text) {
                this.main_text = main_text;
            }

            public String getSecondary_text() {
                return secondary_text;
            }

            public void setSecondary_text(String secondary_text) {
                this.secondary_text = secondary_text;
            }

            public List<MainTextMatchedSubstringsBean> getMain_text_matched_substrings() {
                return main_text_matched_substrings;
            }

            public void setMain_text_matched_substrings(List<MainTextMatchedSubstringsBean> main_text_matched_substrings) {
                this.main_text_matched_substrings = main_text_matched_substrings;
            }

            public static class MainTextMatchedSubstringsBean {
                /**
                 * length : 4
                 * offset : 0
                 */

                private int length;
                private int offset;

                public int getLength() {
                    return length;
                }

                public void setLength(int length) {
                    this.length = length;
                }

                public int getOffset() {
                    return offset;
                }

                public void setOffset(int offset) {
                    this.offset = offset;
                }
            }
        }

        public static class MatchedSubstringsBean {
            /**
             * length : 4
             * offset : 0
             */

            private int length;
            private int offset;

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }
        }

        public static class TermsBean {
            /**
             * offset : 0
             * value : 1600
             */

            private int offset;
            private String value;

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
