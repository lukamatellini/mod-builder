# Mod QA Test Plan: Stormcallers Rod

**Mod ID:** `stormcallersrod`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-28T01:07:49.779Z
**Total Tests:** 4

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p stormcallersrod:power_shard
/give @p stormcallersrod:lightning_wand
```

## Items

### 🤖 Power Shard Registration

**Command:** `/give @p stormcallersrod:power_shard`

**Steps:**
1. Run: /give @p stormcallersrod:power_shard
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Lightning Wand Registration

**Command:** `/give @p stormcallersrod:lightning_wand`

**Steps:**
1. Run: /give @p stormcallersrod:lightning_wand
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Power Shard Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:blaze_powder","minecraft:blaze_powder","minecraft:blaze_powder"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Power Shard

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Lightning Wand Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["stormcallersrod:power_shard","minecraft:blaze_powder","minecraft:blaze_powder"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Lightning Wand

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 2 | [ ] | [ ] |
| Recipes | 2 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_