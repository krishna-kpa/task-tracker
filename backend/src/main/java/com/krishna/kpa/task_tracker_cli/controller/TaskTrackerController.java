package com.krishna.kpa.task_tracker_cli.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controller - this allows users to perform all operations that are related to task.
 *
 * @author Krishna Prasad A
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Task Tracker API",
                version = "1.0",
                description = "Handles task related operations",
                contact = @Contact(
                        name = "krishna prasad a",
                        email = "krishnaprasad.kp9048@gmail.com",
                        url = "https://krishna-kpa.vercel.app/")),

        tags = @Tag(
                name = "Task Tracker Controller",
                description = "all operations that are related to task"))
public interface TaskTrackerController {

}
