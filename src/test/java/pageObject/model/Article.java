package pageObject.model;

import org.openqa.selenium.WebElement;

public class Article {
    private String title;
    private int commentCount;
    private String imgUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
    public void setCommentCount(WebElement commentCount) {
        String commentToParse =  commentCount.getText(); // -> (36) :: String
        commentToParse = commentToParse.substring(1,commentToParse.length()-1); // -> 36 :: String
        this.commentCount = Integer.parseInt(commentToParse); //-> 36 :: int

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
