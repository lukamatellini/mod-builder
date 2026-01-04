# Mod QA Test Plan: Speed Boots

**Mod ID:** `speedboots`
**Minecraft Version:** 1.21.1
**Generated:** 2026-01-04T22:45:32.832Z
**Total Tests:** 3

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p speedboots:speed_boots
```

## Items

### 🤖 Speed Boots Registration

**Command:** `/give @p speedboots:speed_boots`

**Steps:**
1. Run: /give @p speedboots:speed_boots
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Speed Boots Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","minecraft:stick"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Speed Boots

- [ ] PASS
- [ ] FAIL: _________________

## Item Effects

### 👤 Speed Boots when_equipped Effect

**Steps:**
1. Give yourself the item: /give @p speedboots:speed_boots
2. Trigger: when_equipped
3. Observe speed activation

**Expected:** speed activates correctly

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 1 | [ ] | [ ] |
| Recipes | 1 | [ ] | [ ] |
| Item Effects | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_