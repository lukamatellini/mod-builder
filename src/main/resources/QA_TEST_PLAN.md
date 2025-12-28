# Mod QA Test Plan: Swiftfoot Boots

**Mod ID:** `swiftfootboots`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-28T01:18:01.959Z
**Total Tests:** 7

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p swiftfootboots:swiftfoot_boots
/give @p swiftfootboots:swift_ingot
/give @p swiftfootboots:swift_gem
```

## Items

### 🤖 Swiftfoot Boots Registration

**Command:** `/give @p swiftfootboots:swiftfoot_boots`

**Steps:**
1. Run: /give @p swiftfootboots:swiftfoot_boots
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Swift Ingot Registration

**Command:** `/give @p swiftfootboots:swift_ingot`

**Steps:**
1. Run: /give @p swiftfootboots:swift_ingot
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Swift Gem Registration

**Command:** `/give @p swiftfootboots:swift_gem`

**Steps:**
1. Run: /give @p swiftfootboots:swift_gem
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Swiftfoot Boots Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["swiftfootboots:swift_ingot","swiftfootboots:swift_gem"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Swiftfoot Boots

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Swift Ingot Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","minecraft:stick"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Swift Ingot

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Swift Gem Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["swiftfootboots:swift_ingot"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Swift Gem

- [ ] PASS
- [ ] FAIL: _________________

## Item Effects

### 👤 Swiftfoot Boots passive Effect

**Steps:**
1. Give yourself the item: /give @p swiftfootboots:swiftfoot_boots
2. Hold item and wait
3. Observe minecraft:speed activation

**Expected:** minecraft:speed activates correctly

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 3 | [ ] | [ ] |
| Recipes | 3 | [ ] | [ ] |
| Item Effects | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_