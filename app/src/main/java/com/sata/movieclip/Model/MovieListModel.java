package com.sata.movieclip.Model;

import java.util.List;

public class MovieListModel {

    private List<Search> Search;

    public List<Search> getSearch() {
        return Search;
    }

    public void setSearch(List<Search> search) {
        Search = search;
    }
    public class Search {
        private String Title;
        private String Year;
        private String imdbID;
        private String Type;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getYear() {
            return Year;
        }

        public void setYear(String year) {
            Year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public String getPoster() {
            return Poster;
        }

        public void setPoster(String poster) {
            Poster = poster;
        }

        private String Poster;
    }
}
