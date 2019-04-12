/*
 * Copyright 2017 - 2019 Michael Rapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package de.mrapp.apriori.tasks

import de.mrapp.apriori.Apriori

/**
 * An abstract base class for all tasks, which execute a module multiple times in order to obtain
 * the results, which are requested according to a specific configuration.
 *
 * @property configuration The configuration that is used by the task
 * @author Michael Rapp
 * @since 1.0.0
 */
abstract class AbstractTask(val configuration: Apriori.Configuration)
