package pl.sebastian.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="task")
public class Task implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="task_name")
    private String taskName;

    @Column(name="task_description")
    private String taskDescription;
    @Column(name="status")
    private boolean status;
    @Column(name="created_date")

    private Date createdDate;

    @Column(name="final_date")
    private String finalDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDesccription) {
        this.taskDescription = taskDesccription;
    }

    public String getStatus() {
        if(status)
            return "Wykonane";
        return "Niewykonane";
    }
    public void setStatus(boolean status) {
        this.status=status;
    }

    public Date getCreatedDate() {//bylo Date getCreatedDate()


        return createdDate;// return createdDate; <<bylo
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }





    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }
}
