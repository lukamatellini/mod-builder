# QA Test Plan: Blocky Fortune

Generated: 2026-01-06T14:56:18.003Z
Minecraft Version: 1.21.1
Mod ID: blockyfortune

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 31 |
| Passed | 26 |
| Failed | 0 |
| Warnings | 2 |
| Skipped | 3 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `blockyfortune.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lucky Block | `/give @p blockyfortune:lucky_block` | ☐ | ☐ | ☐ |
| Cooked Beef  | `/give @p blockyfortune:cooked_beef_` | ☐ | ☐ | ☐ |
| Player Haste Effect 30s | `/give @p blockyfortune:player_haste_effect_30s` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Block"
- [ ] Crafting recipe works

#### Cooked Beef 

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cooked Beef "

#### Player Haste Effect 30s

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Player Haste Effect 30s"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p blockyfortune:lucky_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
