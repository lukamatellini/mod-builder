# Mod QA Test Plan: Stride Enchant

**Mod ID:** `strideenchant`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-26T22:38:30.799Z
**Total Tests:** 6

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p strideenchant:swift_feather
/give @p strideenchant:swift_gem
/give @p strideenchant:swiftstride_boots
```

## Items

### 🤖 Swift Feather Registration

**Command:** `/give @p strideenchant:swift_feather`

**Steps:**
1. Run: /give @p strideenchant:swift_feather
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Swift Gem Registration

**Command:** `/give @p strideenchant:swift_gem`

**Steps:**
1. Run: /give @p strideenchant:swift_gem
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Swiftstride Boots Registration

**Command:** `/give @p strideenchant:swiftstride_boots`

**Steps:**
1. Run: /give @p strideenchant:swiftstride_boots
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Swift Gem Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:diamond","minecraft:sugar","minecraft:emerald"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Swift Gem

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Swiftstride Boots Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:diamond_boots","minecraft:diamond"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Swiftstride Boots

- [ ] PASS
- [ ] FAIL: _________________

## Item Effects

### 👤 Swiftstride Boots passive Effect

**Steps:**
1. Give yourself the item: /give @p strideenchant:swiftstride_boots
2. Hold item and wait
3. Observe minecraft:speed activation

**Expected:** minecraft:speed activates correctly

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 3 | [ ] | [ ] |
| Recipes | 2 | [ ] | [ ] |
| Item Effects | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_