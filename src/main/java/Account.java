import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {

    Integer id;

    boolean marked;

    boolean markedSecondDirection;

    List<Account> children = new ArrayList<>();

    public Account(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean isMarkedSecondDirection() {
        return markedSecondDirection;
    }

    public void setMarkedSecondDirection(boolean markedSecondDirection) {
        this.markedSecondDirection = markedSecondDirection;
    }

    public List<Account> getChildren() {
        return children;
    }

    public void setChildren(List<Account> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
