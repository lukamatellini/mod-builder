# Mod QA Test Plan: Anti-Gravity Generator

**Mod ID:** `antigravitygenerator`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-27T21:00:48.738Z
**Total Tests:** 3

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p antigravitygenerator:gravity_core
```

## Items

### 🤖 Gravity Core Registration

**Command:** `/give @p antigravitygenerator:gravity_core`

**Steps:**
1. Run: /give @p antigravitygenerator:gravity_core
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Gravity Core Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","minecraft:stick","minecraft:stick"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Gravity Core

- [ ] PASS
- [ ] FAIL: _________________

## Blocks

### 👤 Anti-Gravity Generator Placement

**Command:** `/give @p antigravitygenerator:anti_gravity_generator`

**Steps:**
1. Run: /give @p antigravitygenerator:anti_gravity_generator
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 1 | [ ] | [ ] |
| Recipes | 1 | [ ] | [ ] |
| Blocks | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_