package entity;

import java.util.List;

public class ScoreDetail {
    private Subject subject;
    private float score;

    public ScoreDetail(Subject subject, float score) {
        this.subject=subject;
        this.score=score;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoreDetail{" +
                "subject=" + subject +
                ", score=" + score +
                '}';
    }
}
