/**
 * Copyright (C) 2018 ConnId (connid-dev@googlegroups.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.tirasa.connid.bundles.scim.common.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import net.tirasa.connid.bundles.scim.common.dto.PagedResults;
import net.tirasa.connid.bundles.scim.common.dto.SCIMBaseMeta;
import net.tirasa.connid.bundles.scim.common.dto.SCIMBasePatch;
import net.tirasa.connid.bundles.scim.common.dto.SCIMBaseResource;
import net.tirasa.connid.bundles.scim.common.dto.SCIMEnterpriseUser;
import net.tirasa.connid.bundles.scim.common.dto.SCIMGroup;
import net.tirasa.connid.bundles.scim.common.dto.SCIMUser;

public interface SCIMService<UT extends SCIMUser<? extends SCIMBaseMeta, ? extends SCIMEnterpriseUser<?>>, 
        GT extends SCIMGroup<? extends SCIMBaseMeta>, ERT extends SCIMBaseResource<? extends SCIMBaseMeta>,
        P extends SCIMBasePatch> {

    PagedResults<UT> getAllUsers(Integer valueOf, Integer pagesSize, Set<String> attributesToGet);

    PagedResults<UT> getAllUsers(Integer valueOf, Integer pagesSize, Set<String> attributesToGet,
                         Map<String, String> queryParams);

    List<UT> getAllUsers(Set<String> attributesToGet);

    List<UT> getAllUsers(Set<String> attributesToGet, Map<String, String> queryParams);

    UT getUser(String userId);

    UT getUser(String userId, Map<String, String> queryParams);

    UT getMeUser();

    List<UT> getAllUsers(String s, Set<String> attributesToGet);

    List<UT> getAllUsers(String s, Set<String> attributesToGet, Map<String, String> queryParams);

    UT createUser(UT user);

    void deleteUser(String userId);

    UT updateUser(UT user);

    void activateUser(String userId);

    boolean testService();

    PagedResults<GT> getAllGroups(Integer startIndex, Integer count);

    PagedResults<GT> getAllGroups(Integer startIndex, Integer count, Map<String, String> queryParams);

    List<GT> getAllGroups();

    List<GT> getAllGroups(Map<String, String> queryParams);

    GT getGroup(String groupId);

    GT getGroup(String groupId, Map<String, String> queryParams);

    List<GT> getAllGroups(String filter);

    List<GT> getAllGroups(String filter, Map<String, String> queryParams);

    PagedResults<GT> getAllGroups(String filter, Integer startIndex, Integer count, Map<String, String> queryParams);

    GT createGroup(GT group);

    void deleteGroup(String groupId);

    GT updateGroup(GT group);

    GT updateGroup(String groupId, P groupPatch);
    
    ERT getEntitlement(String entitlementId);
}
