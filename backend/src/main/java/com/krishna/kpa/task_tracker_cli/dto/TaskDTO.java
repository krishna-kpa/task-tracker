package com.krishna.kpa.task_tracker_cli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.krishna.kpa.task_tracker_cli.enums.TaskStatus;
import com.krishna.kpa.task_tracker_cli.validation.groups.ApiInputCreate;
import com.krishna.kpa.task_tracker_cli.validation.groups.ApiInputUpdate;
import com.krishna.kpa.task_tracker_cli.validation.groups.ApiOutput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.FIELD_ALERT_TIME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.FIELD_CREATED_TIME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.FIELD_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.FIELD_ID;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.FIELD_LAST_UPDATED_TIME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.FIELD_NAME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.FIELD_STATUS;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.ALERT_TIME_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.CREATED_TIME_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.DESCRIPTION_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.EXAMPLE_ALERT_TIME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.EXAMPLE_CREATED_TIME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.EXAMPLE_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.EXAMPLE_ID;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.EXAMPLE_LAST_UPDATED_TIME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.EXAMPLE_NAME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.EXAMPLE_STATUS;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.ID_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.LAST_UPDATED_TIME_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.NAME_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.SCHEMA_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.SCHEMA_NAME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.STATUS_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_ALERT_TIME_NULL;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_CREATED_TIME_NULL;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_DESCRIPTION_BLANK;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_DESCRIPTION_SIZE;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_ID_POSITIVE;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_LAST_UPDATED_NULL;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_NAME_BLANK;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_NAME_SIZE;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_STATUS_NULL;

/**
 * DTO for representing task
 *
 * @author Krishna Prasad A
 */
@Schema(
        name = SCHEMA_NAME,
        description = SCHEMA_DESCRIPTION
)
@Getter
@Setter
public class TaskDTO {

    @Schema(name = FIELD_ID, description = ID_DESCRIPTION, example = EXAMPLE_ID)
    @JsonProperty(FIELD_ID)
    @JsonView(ApiOutput.class)
    @Positive(message = "{" + KEY_ID_POSITIVE + "}", groups = ApiOutput.class)
    private Integer id;

    @Schema(name = FIELD_NAME, description = NAME_DESCRIPTION, example = EXAMPLE_NAME)
    @JsonProperty(FIELD_NAME)
    @JsonView({ApiOutput.class, ApiInputCreate.class, ApiInputUpdate.class})
    @NotBlank(message = "{" + KEY_NAME_BLANK + "}", groups = {ApiInputCreate.class, ApiOutput.class})
    @Size(min = 1, max = 100, message = "{" + KEY_NAME_SIZE + "}", groups = {ApiInputCreate.class, ApiInputUpdate.class, ApiOutput.class})
    private String name;

    @Schema(name = FIELD_DESCRIPTION, description = DESCRIPTION_DESCRIPTION, example = EXAMPLE_DESCRIPTION)
    @JsonProperty(FIELD_DESCRIPTION)
    @JsonView({ApiOutput.class, ApiInputCreate.class, ApiInputUpdate.class})
    @NotBlank(message = "{" + KEY_DESCRIPTION_BLANK + "}", groups = {ApiInputCreate.class, ApiOutput.class})
    @Size(min = 1, max = 255, message = "{" + KEY_DESCRIPTION_SIZE + "}", groups = {ApiInputCreate.class, ApiInputUpdate.class, ApiOutput.class})
    private String description;

    @Schema(name = FIELD_ALERT_TIME, description = ALERT_TIME_DESCRIPTION, example = EXAMPLE_ALERT_TIME)
    @JsonProperty(FIELD_ALERT_TIME)
    @JsonView({ApiOutput.class, ApiInputCreate.class, ApiInputUpdate.class})
    @NotNull(message = "{" + KEY_ALERT_TIME_NULL + "}", groups = {ApiOutput.class, ApiInputCreate.class})
    private LocalDateTime alertTime;

    @Schema(name = FIELD_STATUS, description = STATUS_DESCRIPTION, example = EXAMPLE_STATUS)
    @JsonProperty(FIELD_STATUS)
    @JsonView({ApiOutput.class, ApiInputCreate.class, ApiInputUpdate.class})
    @NotNull(message = "{" + KEY_STATUS_NULL + "}", groups = {ApiOutput.class, ApiInputCreate.class})
    private TaskStatus status;

    @Schema(name = FIELD_LAST_UPDATED_TIME, description = LAST_UPDATED_TIME_DESCRIPTION, example = EXAMPLE_LAST_UPDATED_TIME)
    @JsonProperty(FIELD_LAST_UPDATED_TIME)
    @JsonView(ApiOutput.class)
    @NotNull(message = "{" + KEY_LAST_UPDATED_NULL + "}", groups = ApiOutput.class)
    private LocalDateTime lastUpdatedTime;

    @Schema(name = FIELD_CREATED_TIME, description = CREATED_TIME_DESCRIPTION, example = EXAMPLE_CREATED_TIME)
    @JsonProperty(FIELD_CREATED_TIME)
    @JsonView(ApiOutput.class)
    @NotNull(message = "{" + KEY_CREATED_TIME_NULL + "}", groups = ApiOutput.class)
    private LocalDateTime createdTime;
}