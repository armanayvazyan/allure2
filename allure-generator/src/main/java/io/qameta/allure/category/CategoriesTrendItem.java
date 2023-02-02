/*
 *  Copyright 2016-2023 Qameta Software OÜ
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.qameta.allure.category;

import io.qameta.allure.entity.TestResult;
import io.qameta.allure.trend.TrendItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author charlie (Dmitry Baev).
 */
public class CategoriesTrendItem extends TrendItem {

    public void increaseCategories(final TestResult result) {
        result.<List<Category>>getExtraBlock("categories", new ArrayList<>()).stream()
                .map(Category::getName)
                .forEach(this::increaseCategories);
    }

    private void increaseCategories(final String name) {
        increaseMetric(name);
    }

}
