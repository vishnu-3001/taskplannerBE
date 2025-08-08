package com.taskplanner.taskplanner.repo;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import com.taskplanner.taskplanner.model.*;
import java.util.*;

@Repository
public interface TaskRepo extends JpaRepository<Task,String> {
    List<Task> findByUserId(long userId);
    List<Task> findByUserIdAndTaskStatus(long userId, int taskStatus);
} 
